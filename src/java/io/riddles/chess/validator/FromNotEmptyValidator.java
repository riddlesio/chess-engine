package io.riddles.chess.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Field;
import io.riddles.boardgame.model.Move;
import io.riddles.chess.model.ChessState;
import io.riddles.game.validator.MoveValidator;

/**
 * ${PACKAGE_NAME}
 *
 * This file is a part of chess
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public class FromNotEmptyValidator implements MoveValidator {

    @Override
    public Boolean isApplicable(Move move, Board board) {

        return true;
    }

    @Override
    public Boolean isValid(Move move, Board board, ChessState state) {

        Coordinate from = move.getFrom();

        Field field = board.getFieldAt(from);

        return field.getPiece().map(piece -> true).orElse(false);

//        throw new IllegalMoveException("There is no chess chessPiece at the specified source field");
    }
}
