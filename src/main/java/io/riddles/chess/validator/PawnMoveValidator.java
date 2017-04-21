package io.riddles.chess.validator;

import io.riddles.chess.data.ChessPiece;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.model.ChessPieceColor;
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
public class PawnMoveValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return this.isMovedPieceOfType(move, state.getBoard(), ChessPieceType.PAWN);
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {

        Point from = move.getFrom();
        Point to = move.getTo();

        int deltaX = to.x - from.x;
        int deltaY = to.y - from.y;

        ChessPiece chessPiece = (ChessPiece) state.getBoard().getFieldAt(from);
        ChessPieceColor pieceColor = chessPiece.getColor();

        boolean isValid;
        if (ChessPieceColor.BLACK == pieceColor) {
            if (!chessPiece.hasMoved())
                isValid = deltaX == 0 && (deltaY == 1 || deltaY == 2);
            else
                isValid = deltaX == 0 && deltaY == 1;
        } else {
            if (!chessPiece.hasMoved())
                isValid = deltaX == 0 && (deltaY == -1 || deltaY == -2);
            else
                isValid = deltaX == 0 && deltaY == -1;
        }

        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The pawn can only move forward to the unoccupied square immediately in front of it on the same file, or on its first move it can advance two squares along the same file.");
    }
}
