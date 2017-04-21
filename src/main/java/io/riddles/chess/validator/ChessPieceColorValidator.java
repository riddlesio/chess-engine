package io.riddles.chess.validator;

import io.riddles.chess.data.ChessPiece;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ChessMove;
import io.riddles.chess.model.ValidationResult;
import io.riddles.chess.model.*;

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
public class ChessPieceColorValidator extends ChessPieceMoveValidator implements MoveValidator<ChessState> {

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return true;
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {

        ChessPiece piece = state.getBoard().getFieldAt(move.getFrom());
        if (piece.getColor() == getPlayerColor(state.getPlayerId())) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "This piece doesn't belong to you");
    }


    public ChessPieceColor getPlayerColor(int playerId) {
        return (playerId == 0) ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
    }
}