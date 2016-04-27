package io.riddles.chess.move.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
import io.riddles.chess.model.*;
import io.riddles.game.move.MoveValidator;

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
public class BishopMoveValidator extends ChessPieceMoveValidator implements MoveValidator {

    @Override
    public Boolean isApplicable(Move move, Board board) {

        return this.isMovedPieceOfType(move, board, ChessPieceType.BISHOP);
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        int deltaX = Math.abs(to.getX() - from.getX());
        int deltaY = Math.abs(to.getY() - from.getY());

        return deltaX == deltaY;

//        throw new IllegalMoveException("The bishop can only move diagonally");
    }
}
