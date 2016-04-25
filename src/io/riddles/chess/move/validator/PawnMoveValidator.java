package io.riddles.chess.move.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Piece;
import io.riddles.chess.model.*;
import io.riddles.move.MoveValidator;

import java.util.Optional;

/**
 * Created by Niko on 26/03/16.
 */
public class PawnMoveValidator extends ChessPieceMoveValidator implements MoveValidator {

    @Override
    public Boolean isApplicable(Move move, Board board) {

        return this.isMovedPieceOfType(move, board, ChessPieceType.PAWN);
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        ChessPiece chessPiece = (ChessPiece) board.getFieldAt(from).getPiece().get();
        ChessPieceColor pieceColor = chessPiece.getColor();

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        if (ChessPieceColor.BLACK == pieceColor) {

            return deltaX == 0 && deltaY == -1;
        }

        return deltaX == 0 && deltaY == 1;

//        throw new IllegalMoveException("The king can only move a distance of one square in any direction");
    }
}
