package io.riddles.chess.validator;

import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.data.ChessPiece;
import io.riddles.chess.model.ChessPieceType;
import io.riddles.chess.move.ChessMove;

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


    protected Boolean isMovedPieceOfType(ChessMove move, ChessBoard board, ChessPieceType pieceType) {
        ChessPiece piece = board.getFieldAt(move.getFrom());
        return piece.hasType(pieceType);
    }
}
