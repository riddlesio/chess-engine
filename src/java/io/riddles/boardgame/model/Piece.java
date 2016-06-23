package io.riddles.boardgame.model;

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
public abstract class Piece<ChessPieceType, PieceColor> extends AbstractModel {

	
	public enum PieceColor{
		BLACK,
		WHITE
	}
	
    protected PieceColor color;
    protected ChessPieceType type;

    public Piece(ChessPieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    public Boolean hasColor(PieceColor color) {
        return this.color == color;
    }

    public Boolean hasType(ChessPieceType type) {
        return this.type == type;
    }

    public PieceColor getColor() {
        return this.color;
    }

    public ChessPieceType getType() {
        return this.type;
    }
}
