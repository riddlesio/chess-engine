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
public class PawnMoveValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return this.isMovedPieceOfType(move, state.getBoard(), ChessPieceType.PAWN);
    }

    @Override
    public ValidationResult isValid(ChessMove move, ChessState state) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        ChessPiece chessPiece = (ChessPiece) state.getBoard().getFieldAt(from).getPiece().get();
        ChessPieceColor pieceColor = chessPiece.getColor();

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        boolean isValid;
        if (ChessPieceColor.BLACK == pieceColor) {
            isValid = deltaX == 0 && deltaY == -1;
        } else {
            isValid = deltaX == 0 && deltaY == 1;
        }

        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The king can only move a distance of one square in any direction");
    }
}
