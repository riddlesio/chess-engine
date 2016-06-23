package io.riddles.chess.logic;

import io.riddles.boardgame.logic.PieceLogic;
import io.riddles.chess.model.ChessPiece;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ChessPieceType;

import static io.riddles.chess.model.ChessPieceColor.*;
import static io.riddles.chess.model.ChessPieceType.*;

/**
 * Created by Niko on 29/05/16.
 */
public class ChessPieceLogic extends PieceLogic<ChessPieceType, ChessPieceColor> {

    public boolean hasColorBlack(ChessPiece piece) {
        return hasColor(BLACK, piece);
    }

    public boolean hasColorWhite(ChessPiece piece) {
        return hasColor(WHITE, piece);
    }

    public boolean hasTypeBishop(ChessPiece piece) {
        return hasType(BISHOP, piece);
    }

    public boolean hasTypeKing(ChessPiece piece) {
        return hasType(KING, piece);
    }

    public boolean hasTypeKnight(ChessPiece piece) {
        return hasType(KNIGHT, piece);
    }

    public boolean hasTypePawn(ChessPiece piece) {
        return hasType(PAWN, piece);
    }

    public boolean hasTypeQueen(ChessPiece piece) {
        return hasType(QUEEN, piece);
    }

    public boolean hasTypeRook(ChessPiece piece) {
        return hasType(ROOK, piece);
    }
}
