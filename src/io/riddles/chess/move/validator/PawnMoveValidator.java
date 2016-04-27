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
public class PawnMoveValidator extends ChessPieceMoveValidator implements MoveValidator {

    @Override
    public Boolean isApplicable(Move move, Board board) {

        return this.isMovedPieceOfType(move, board, ChessPieceType.PAWN);
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        ChessPiece chessPiece = (ChessPiece) board.getFieldAt(from).getPiece().get();
        ChessPieceColor pieceColor = chessPiece.getColor();

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        if (ChessPieceColor.BLACK == pieceColor) {

            return deltaX == 0 && deltaY == -1;
        }

        return deltaX == 0 && deltaY == 1;

//        throw new IllegalMoveException("The king can only move a distance of one square in any direction");
    }
}
