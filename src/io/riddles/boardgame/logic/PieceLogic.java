package io.riddles.boardgame.logic;

import io.riddles.boardgame.model.Piece;

/**
 * Created by Niko on 29/05/16.
 */
public class PieceLogic<PieceType, PieceColor> {

    public boolean hasColor(PieceColor color, Piece piece) {
        return piece.getColor() == color;
    }

    public boolean hasType(PieceType type, Piece piece) {
        return piece.getType() == type;
    }
}
