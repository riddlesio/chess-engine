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
public class RookMoveValidator extends ChessPieceMoveValidator implements MoveValidator {

    public Boolean isApplicable(Move move, Board board) {

        return this.isMovedPieceOfType(move, board, ChessPieceType.ROOK);
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        return deltaX == 0 || deltaY == 0;

//        throw new IllegalMoveException("The bishop can only move diagonally");
    }
}
