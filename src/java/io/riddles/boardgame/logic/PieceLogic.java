package io.riddles.boardgame.logic;

import io.riddles.boardgame.model.Piece;

/**
 * This class contains generic logic for Pieces
 */
public class PieceLogic<PieceType, PieceColor> {

    /**
     * Checks if piece has the designated color
     * @param color the color to check against
     * @param piece the piece which color to check
     * @return True if piece has PieceColor color, false otherwise
     */
    public boolean hasColor(PieceColor color, Piece piece) {
        return piece.getColor() == color;
    }

    /**
     * Checks if piece has the designated type
     * @param type  the type to check against
     * @param piece the piece which type to check
     * @return True if piece has PieceType type, false otherwise
     */
    public boolean hasType(PieceType type, Piece piece) {
        return piece.getType() == type;
    }
}
