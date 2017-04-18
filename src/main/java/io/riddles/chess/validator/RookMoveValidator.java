package io.riddles.chess.validator;

import io.riddles.chess.move.ChessMove;
import io.riddles.boardgame.model.ValidationResult;
import io.riddles.chess.model.*;
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
public class RookMoveValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    public Boolean isApplicable(ChessMove move, ChessState state) {

        return this.isMovedPieceOfType(move, state.getBoard(), ChessPieceType.ROOK);
    }

    @Override
    public ValidationResult isValid(ChessMove move, ChessState state) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        boolean isValid = deltaX == 0 || deltaY == 0;
        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The rook can only move in a horizontal or vertical line");
    }
}
