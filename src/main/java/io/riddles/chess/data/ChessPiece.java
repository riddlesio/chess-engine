package io.riddles.chess.data;

import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ChessPieceType;

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
public class ChessPiece {
    ChessPieceType type;
    ChessPieceColor color;
    private boolean hasMoved;

    public ChessPiece(ChessPieceType type, ChessPieceColor color) {
        this.type = type;
        this.color = color;
    }

    public ChessPiece(ChessPiece piece) {
        this.hasMoved = piece.hasMoved();
        this.color = piece.getColor();
        this.type = piece.getType();
    }

    public Boolean hasColor(ChessPieceColor color) {
        return this.color == color;
    }

    public Boolean hasType(ChessPieceType type) {
        return this.type == type;
    }

    public ChessPieceColor getColor() {
        return this.color;
    }

    public ChessPieceType getType() {
        return this.type;
    }

    public void setMoved() { this.hasMoved = true; }
    public boolean hasMoved() { return this.hasMoved; }
}
