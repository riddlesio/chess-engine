package io.riddles.boardgame.model;

/**
 * Created by Niko on 28/03/16.
 */
public abstract class Piece<PieceType extends Enum<PieceType>, PieceColor extends Enum<PieceColor>> extends AbstractModel {

    protected PieceColor color;
    protected PieceType type;

    public Piece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    public Boolean hasColor(PieceColor color) {
        return this.color == color;
    }

    public Boolean hasType(PieceType type) {
        return this.type == type;
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getType() {
        return type;
    }
}
