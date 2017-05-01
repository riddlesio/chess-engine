package io.riddles.chess.validator;

import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.data.ChessPiece;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.model.ValidationResult;
import io.riddles.chess.move.ChessMove;

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
public class ToEmptyOrOppositePlayerValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {
        return true;
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {

        Point to = move.getTo();
        Point from = move.getFrom();

        ChessBoard board = state.getBoard();

        ChessPiece toPiece = board.getFieldAt(to);
        ChessPiece fromPiece = board.getFieldAt(from);

        boolean isValid = false;

        if (toPiece == null) {
            isValid = true;
        } else {
            if (toPiece.getColor() != fromPiece.getColor()) {
                isValid = true;
            }
        }


        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "Your piece already occupies that field.");
    }
}
