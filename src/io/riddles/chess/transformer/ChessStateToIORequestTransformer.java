package io.riddles.chess.transformer;

import io.riddles.boardgame.logic.SquareBoardLogic;
import io.riddles.boardgame.model.*;
import io.riddles.chess.io.ChessIORequest;
import io.riddles.chess.io.ChessIORequestType;
import io.riddles.chess.logic.ChessPieceLogic;
import io.riddles.chess.model.ChessPiece;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ChessState;
import io.riddles.game.transformer.Transformer;

import java.util.Optional;

/**
 * Created by Niko on 29/05/16.
 */
public class ChessStateToIORequestTransformer implements Transformer<ChessState, ChessIORequest> {

    SquareBoardLogic boardLogic;
    ChessPieceLogic pieceLogic;

    public ChessStateToIORequestTransformer() {
        boardLogic = new SquareBoardLogic();
        pieceLogic = new ChessPieceLogic();
    }

    @Override
    public ChessIORequest transform(ChessState state) {

        Move previousMove;
        Optional<Move> optionalPreviousMove = state.getMove();

        // Handle game start
        if (!optionalPreviousMove.isPresent()) {
            return createInitialMoveRequest();
        }

        previousMove = optionalPreviousMove.get();

        // Handle promotion
        if (stateHasPromotablePiece(state, previousMove)) {
            return createPromotionRequest(state, previousMove);
        }

        // Everything else is a simple move request
        return createMoveRequest(state, previousMove);
    }

    protected ChessIORequest createMoveRequest(ChessState state, Move previousMove) {

        ChessPieceColor colorToMove;
        ChessPiece movedPiece = getMovedPiece(state, previousMove);

        if (pieceLogic.hasColorBlack(movedPiece)) {
            colorToMove = ChessPieceColor.WHITE;
        } else {
            colorToMove = ChessPieceColor.BLACK;
        }

        return new ChessIORequest(colorToMove, ChessIORequestType.MOVE);
    }

    protected ChessIORequest createInitialMoveRequest() {

        return new ChessIORequest(ChessPieceColor.WHITE, ChessIORequestType.MOVE);
    }

    protected ChessIORequest createPromotionRequest(ChessState state, Move move) {

        Coordinate coordinate = move.getTo();
        ChessPieceColor pieceColor = getColorOfMovedPiece(state, move);

        return new ChessIORequest(pieceColor, ChessIORequestType.PROMOTE, coordinate);
    }

    protected boolean stateHasPromotablePiece(ChessState state, Move previousMove) {

        SquareBoard board = (SquareBoard) state.getBoard();
        Coordinate coordinate = previousMove.getTo();
        ChessPiece movedPiece = getMovedPiece(state, previousMove);

        if (!pieceLogic.hasTypePawn(movedPiece)) {
            return false;
        }

        if (pieceLogic.hasColorWhite(movedPiece)) {
            return boardLogic.isCoordinateAtBottomEdge(coordinate, board);
        }

        return boardLogic.isCoordinateAtTopEdge(coordinate, board);
    }

    protected ChessPieceColor getColorOfMovedPiece(ChessState state, Move move) {

        Piece piece = getMovedPiece(state, move);
        return (ChessPieceColor) piece.getColor();
    }

    protected ChessPiece getMovedPiece(ChessState state, Move move) {
        Coordinate coordinate = move.getTo();

        Optional<Piece> optionalPiece = state
                .getBoard()
                .getFieldAt(coordinate)
                .getPiece();

        if(!optionalPiece.isPresent()) {
            throw new RuntimeException("No piece present at target coordinate");
        }

        return (ChessPiece) optionalPiece.get();
    }
}
