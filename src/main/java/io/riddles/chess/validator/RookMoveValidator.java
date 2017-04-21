package io.riddles.chess.validator;

import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ChessMove;
import io.riddles.chess.model.ValidationResult;
import io.riddles.chess.model.*;
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
public class RookMoveValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return this.isMovedPieceOfType(move, state.getBoard(), ChessPieceType.ROOK);
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {

        Point from = move.getFrom();
        Point to = move.getTo();

        int deltaX = Math.abs(to.x - from.x);
        int deltaY = Math.abs(to.y - from.y);

        boolean isValid = deltaX == 0 || deltaY == 0;
        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The rook can only move in a horizontal or vertical line");
    }
}
