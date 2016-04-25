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
public class KnightMoveValidator extends ChessPieceMoveValidator implements MoveValidator {

    @Override
    public Boolean isApplicable(Move move, Board board) {

        return this.isMovedPieceOfType(move, board, ChessPieceType.KNIGHT);
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        int deltaX = Math.abs(to.getX() - from.getX());
        int deltaY = Math.abs(to.getY() - from.getY());

        return deltaX == 1 && deltaY == 2 || deltaX == 2 && deltaY == 1;

//        throw new IllegalMoveException("The king can only move a distance of one square in any direction");
    }
}
