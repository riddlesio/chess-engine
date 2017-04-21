package io.riddles.chess.validator;

import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ChessMove;
import io.riddles.chess.model.ValidationResult;
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
public class QueenMoveValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return this.isMovedPieceOfType(move, state.getBoard(), ChessPieceType.QUEEN);
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {

        MoveValidator bishopMoveValidator = new BishopMoveValidator();
        MoveValidator rookMoveValidator = new RookMoveValidator();

        Boolean isValidBishopMove = bishopMoveValidator.validate(move, state).isValid();
        Boolean isValidRookMove = rookMoveValidator.validate(move, state).isValid();

        boolean isValid = isValidBishopMove || isValidRookMove;
        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The queen can only move horizontally, vertically or diagonally");
    }
}
