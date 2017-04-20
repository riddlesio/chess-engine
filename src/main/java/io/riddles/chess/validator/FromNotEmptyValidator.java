package io.riddles.chess.validator;

import io.riddles.boardgame.model.*;
import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ChessMove;
import io.riddles.game.validator.MoveValidator;

import java.awt.*;

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
public class FromNotEmptyValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return true;
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {

        Point from = move.getFrom();
        ChessBoard board = state.getBoard();
        if (board != null) {
            if (state.getBoard())
        }

        Field field = state.getBoard().getFieldAt(from);

        boolean isValid = field.getPiece().map(piece -> true).orElse(false);
        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "There is no chess chessPiece at the specified source field");
    }
}
