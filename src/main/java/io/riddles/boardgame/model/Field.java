package io.riddles.boardgame.model;

import io.riddles.chess.data.Piece;

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
public class Field extends AbstractModel {

    protected Optional<Piece> maybePiece;

    public Field() {
        maybePiece = Optional.empty();
    }

    public Field(Piece piece) {
        maybePiece = Optional.of(piece);
    }

    public Optional<Piece> getPiece() {

        return maybePiece;
    }

    public void setPiece(Optional<Piece> maybePiece) {
        this.maybePiece = maybePiece;
    }
}
