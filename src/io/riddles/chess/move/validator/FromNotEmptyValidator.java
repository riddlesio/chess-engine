package io.riddles.chess.move.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Field;
import io.riddles.boardgame.model.Move;
import io.riddles.game.move.MoveValidator;

/**
 * Created by Niko on 26/03/16.
 */
public class FromNotEmptyValidator implements MoveValidator {

    @Override
    public Boolean isApplicable(Move move, Board board) {

        return true;
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        Coordinate from = move.getFrom();

        Field field = board.getFieldAt(from);

        return field.getPiece().map(piece -> true).orElse(false);

//        throw new IllegalMoveException("There is no chess chessPiece at the specified source field");
    }
}
