package io.riddles.chess.visitor;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Field;
import io.riddles.boardgame.model.Piece;
import io.riddles.chess.model.*;
import io.riddles.game.model.Traversible;
import io.riddles.game.model.Visitor;

import java.util.Dictionary;
import java.util.Hashtable;
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
public class ChessStateSerializer implements Visitor<String> {

    private Dictionary<ChessPieceType, Character> pieceMap;
    private String state;

    public ChessStateSerializer() {

        pieceMap = new Hashtable<>();
        pieceMap.put(ChessPieceType.BISHOP, 'b');
        pieceMap.put(ChessPieceType.KING,   'k');
        pieceMap.put(ChessPieceType.KNIGHT, 'n');
        pieceMap.put(ChessPieceType.PAWN,   'p');
        pieceMap.put(ChessPieceType.QUEEN,  'q');
        pieceMap.put(ChessPieceType.ROOK,   'r');
    }

    public String traverse (Board board) {

        return board.accept(this);
    }

    public String visit(Board board) {

        String result = "";

        for (Field field : board.getFields()) {

            result = result.concat(field.accept(this));
        }

        return result;
    }

    public String visit(Field field) {

        Optional<Piece> maybePiece = field.getPiece();

        return maybePiece
                .map(piece -> piece.accept(this))
                .orElse(".");
    }

    public String visit(ChessPiece chessPiece) {

        Character p;
        ChessPieceType type;

        type = chessPiece.getType();
        p    = pieceMap.get(type);

        if (ChessPieceColor.WHITE == chessPiece.getColor()) {

            return String.valueOf(p);
        }

        return String.valueOf(Character.toUpperCase(p));
    }

    @Override
    public String visit(Traversible traversible) { return ""; }
}
