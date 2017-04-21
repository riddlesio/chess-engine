package io.riddles.chess.validator;

import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.model.ChessPieceType;
import io.riddles.chess.move.ChessMove;
import io.riddles.chess.model.ValidationResult;

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
public class KingMoveValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return this.isMovedPieceOfType(move, state.getBoard(), ChessPieceType.KING);
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {

        Point from = move.getFrom();
        Point to = move.getTo();

        int deltaX = Math.abs(to.x - from.x);
        int deltaY = Math.abs(to.y - from.y);

        boolean isValid = deltaX <= 1 && deltaY <= 1;
        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The king can only move a distance of one square in any direction");
    }
}
