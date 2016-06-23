package io.riddles.chess.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
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
public class RookMoveValidator extends ChessPieceMoveValidator implements MoveValidator {

    public Boolean isApplicable(Move move, Board board) {

        return this.isMovedPieceOfType(move, board, ChessPieceType.ROOK);
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        return deltaX == 0 || deltaY == 0;

//        throw new IllegalMoveException("The bishop can only move diagonally");
    }
}
