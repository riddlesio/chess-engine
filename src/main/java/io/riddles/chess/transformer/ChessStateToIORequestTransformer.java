package io.riddles.chess.transformer;

import io.riddles.boardgame.logic.SquareBoardLogic;
import io.riddles.boardgame.model.*;
import io.riddles.chess.data.Piece;
import io.riddles.chess.io.ChessIORequest;
import io.riddles.chess.io.ChessIORequestType;
import io.riddles.chess.logic.ChessPieceLogic;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ChessMove;
import io.riddles.game.transformer.Transformer;

import java.util.Optional;

/**
 * Transforms a ChessState into an IORequest
 */
public class ChessStateToIORequestTransformer implements Transformer<ChessState, ChessIORequest> {

    private SquareBoardLogic boardLogic;
    private ChessPieceLogic pieceLogic;

    public ChessStateToIORequestTransformer() {
        boardLogic = new SquareBoardLogic();
        pieceLogic = new ChessPieceLogic();
    }

    /**
     * @inheritDoc
     */
    @Override
    public ChessIORequest transform(ChessState state) {

        Optional<ChessMove> optionalPreviousMove = state.getMove();

        // Handle game start
        if (!optionalPreviousMove.isPresent()) {
            return createInitialMoveRequest();
        }

        // Handle promotion
        if (stateHasPromotablePiece(state)) {
            return createPromotionRequest(state);
        }

        // Everything else is a simple move request
        return createMoveRequest(state);
    }

    /**
     * Creates an IORequest for the next player to move a piece,
     * based on the passed state and move
     * @param state The state upon which to base the next move
     * @return IORequest for the next player to move a piece
     */
    protected ChessIORequest createMoveRequest(ChessState state) {

        ChessPieceColor colorToMove;
        ChessPiece movedPiece = getMovedPiece(state);

        if (movedPiece.hasColor(ChessPieceColor.BLACK)) {
            colorToMove = ChessPieceColor.WHITE;
        } else {
            colorToMove = ChessPieceColor.BLACK;
        }

        return new ChessIORequest(colorToMove, ChessIORequestType.MOVE);
    }

    /**
     * Creates an IORequest for WHITE to move a piece (ie. first move of the game)
     * @return IORequest for WHITE to move a piece
     */
    protected ChessIORequest createInitialMoveRequest() {

        return new ChessIORequest(ChessPieceColor.WHITE, ChessIORequestType.MOVE);
    }

    /**
     * Creates an IORequest for the current player to promote his/her PAWN
     * @param state The state which holds a promotable pawn
     * @return IORequest for the current player to promote the designated pawn
     */
    protected ChessIORequest createPromotionRequest(ChessState state) {

        ChessMove previousMove = getLastMove(state);
        Coordinate coordinate = previousMove.getTo();
        ChessPieceColor pieceColor = getColorOfMovedPiece(state);

        return new ChessIORequest(pieceColor, ChessIORequestType.PROMOTE, coordinate);
    }

    /**
     * Checks whether the passed state holds pawn which can be promoted
     * @param state The state which to check for a promotable piece
     * @return True if the states contains a promotable pawn, false otherwise
     */
    protected boolean stateHasPromotablePiece(ChessState state) {

        SquareBoard board = (SquareBoard) state.getBoard();
        ChessMove previousMove = getLastMove(state);
        Coordinate coordinate = previousMove.getTo();
        ChessPiece movedPiece = getMovedPiece(state);

        if (!pieceLogic.hasTypePawn(movedPiece)) {
            return false;
        }

        if (pieceLogic.hasColorWhite(movedPiece)) {
            return boardLogic.isCoordinateAtBottomEdge(board, coordinate);
        }

        return boardLogic.isCoordinateAtTopEdge(board, coordinate);
    }

    /**
     * Returns the PieceColor of the last moved piece
     * @param state The state from which to retrieve the last moved piece
     * @return ChessPieceColor of the last moved piece
     */
    protected ChessPieceColor getColorOfMovedPiece(ChessState state) {

        Piece piece = getMovedPiece(state);
        return (ChessPieceColor) piece.getColor();
    }

    /**
     * Get the piece which was moved in the previous IOResponse
     * @param state The state from which to retrieve the last moved piece
     * @return The last moved piece
     */
    protected ChessPiece getMovedPiece(ChessState state) {

        ChessMove move = getLastMove(state);
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

    /**
     * Gets the last executed move
     * @param state The state from which to retrieve the last move
     * @return The last executed move
     */
    protected ChessMove getLastMove(ChessState state) {

        Optional<ChessMove> optionalPreviousMove = state.getMove();

        if(!optionalPreviousMove.isPresent()) {
            throw new RuntimeException("No move present in given state");
        }

        return optionalPreviousMove.get();
    }
}
