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
public class BishopMoveValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return this.isMovedPieceOfType(move, state.getBoard(), ChessPieceType.BISHOP);
    }

    @Override
    public ValidationResult isValid(ChessMove move, ChessState state) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        int deltaX = Math.abs(to.getX() - from.getX());
        int deltaY = Math.abs(to.getY() - from.getY());

        boolean isValid = deltaX == deltaY;

        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The bishop can only move diagonally");
    }
}
