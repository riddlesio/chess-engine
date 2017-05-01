package io.riddles.chess.validator;

import io.riddles.chess.model.ValidationResult;
import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.data.ChessPiece;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ChessPieceType;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ChessMove;

import java.awt.*;
import java.util.ArrayList;

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
public final class ChessMoveValidator implements MoveValidator<ChessState> {

    private ArrayList<MoveValidator> validators;

    public ChessMoveValidator() {

        ArrayList<MoveValidator> validators = new ArrayList<>();

        validators.add(new FromNotEmptyValidator());
        validators.add(new ToEmptyOrOppositePlayerValidator());
        validators.add(new ChessPieceColorValidator());
        validators.add(new BishopMoveValidator());
        validators.add(new KingMoveValidator());
        validators.add(new KnightMoveValidator());
        validators.add(new PawnMoveValidator());
        validators.add(new QueenMoveValidator());
        validators.add(new RookMoveValidator());

        this.validators = validators;
    }

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {

        return true;
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {
        ChessBoard board = state.getBoard();

        //get the piece at the from location
        Point from = move.getFrom();
        ChessPiece fromPiece = board.getFieldAt(from);

        boolean result = true;
        for (MoveValidator validator : validators) {
            if (validator.isApplicable(move, state)) {
                ValidationResult vr = validator.validate(move, state);
                if (!vr.isValid()) {
                    return vr;
                }
            }
        }


        /*
        if (validator != null) {
            ValidationResult result = validator.validate(move, state);
            if (!result.isValid()) {
                return result;
            }
        }
        */
        return new ValidationResult(true, "Nice");
    }

}
