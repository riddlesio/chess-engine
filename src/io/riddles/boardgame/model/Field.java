package io.riddles.boardgame.model;

import java.util.Optional;

/**
 * Created by Niko on 28/03/16.
 */
public class Field extends AbstractModel {

    protected Optional<Piece> maybePiece;

    public Field(Optional<Piece> maybePiece) {

        this.maybePiece = maybePiece;
    }

    public Optional<Piece> getPiece() {

        return maybePiece;
    }

    public void setPiece(Optional<Piece> maybePiece) {
        this.maybePiece = maybePiece;
    }
}
