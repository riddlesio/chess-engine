package io.riddles.chess.model;

import io.riddles.boardgame.model.Piece;
import io.riddles.game.model.Visitor;
import io.riddles.game.model.Traversible;

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
public final class ChessPiece extends Piece<ChessPieceType, ChessPieceColor> implements Traversible {

    public ChessPiece(ChessPieceType type, ChessPieceColor color) {

        super(type, color);
    }

    public void setType(ChessPieceType type) {
        this.type = type;
    }

    public static ChessPiece of(ChessPieceType type, ChessPieceColor color) {
        return new ChessPiece(type, color);
    }
}
