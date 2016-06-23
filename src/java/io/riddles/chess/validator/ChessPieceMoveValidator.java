package io.riddles.chess.validator;

import io.riddles.boardgame.logic.PieceLogic;
import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Piece;
import io.riddles.chess.model.ChessPieceColor;
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

    private PieceLogic<ChessPieceType, ChessPieceColor> logic;

    ChessPieceMoveValidator() {
        logic = new PieceLogic<>();
    }

    protected Boolean isMovedPieceOfType(Move move, Board board, ChessPieceType type) {

        Coordinate from = move.getFrom();
        Optional<Piece> optionalPiece = board.getFieldAt(from).getPiece();

        return optionalPiece.map(piece -> logic.hasType(type, piece)).orElse(false);
    }
}
