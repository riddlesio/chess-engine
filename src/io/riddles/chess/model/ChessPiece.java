package io.riddles.chess.model;

import io.riddles.boardgame.model.Piece;
import io.riddles.game.model.Visitor;
import io.riddles.game.model.Traversible;

/**
 * Created by Niko on 24/03/16.
 */
public final class ChessPiece extends Piece<ChessPieceType, ChessPieceColor> implements Traversible {

    public ChessPiece(ChessPieceType type, ChessPieceColor color) {

        super(type, color);
    }

    public void setType(ChessPieceType type) {
        this.type = type;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public static ChessPiece of(ChessPieceType type, ChessPieceColor color) {
        return new ChessPiece(type, color);
    }
}
