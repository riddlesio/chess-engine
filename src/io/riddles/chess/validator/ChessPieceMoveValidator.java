package io.riddles.chess.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Piece;
import io.riddles.chess.model.ChessPieceType;

import java.util.Optional;

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
public abstract class ChessPieceMoveValidator {

    protected Boolean isMovedPieceOfType(Move move, Board board, ChessPieceType type) {

        Coordinate from = move.getFrom();
        Optional<Piece> piece = board.getFieldAt(from).getPiece();

        return piece.map(p -> p.hasType(type)).orElse(false);
    }
}
