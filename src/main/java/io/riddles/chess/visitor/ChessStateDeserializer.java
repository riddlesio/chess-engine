package io.riddles.chess.visitor;

import io.riddles.boardgame.model.Field;
import io.riddles.chess.data.Piece;
import io.riddles.boardgame.model.SquareBoard;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.model.*;

import java.util.ArrayList;
import java.util.HashMap;
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
public class ChessStateDeserializer {

    private HashMap<Character, ChessPieceType> pieceMap;

    public ChessStateDeserializer() {

        pieceMap = new HashMap<>();
        pieceMap.put('b', ChessPieceType.BISHOP);
        pieceMap.put('k', ChessPieceType.KING);
        pieceMap.put('n', ChessPieceType.KNIGHT);
        pieceMap.put('p', ChessPieceType.PAWN);
        pieceMap.put('q', ChessPieceType.QUEEN);
        pieceMap.put('r', ChessPieceType.ROOK);
    }

    public ChessState traverse (String state) {

        Board board = visit(state);
        return new ChessState(board);
    }

    private Board visit(String state) {

        ArrayList<Field> fields = new ArrayList<>();

        for (Character character : state.toCharArray()) {
            fields.add(this.visit(character));
        }

        return new SquareBoard(fields);
    }

    private Field visit(Character c) {

        ChessPiece chessPiece;
        ChessPieceColor color;
        ChessPieceType type;
        Optional<Piece> maybePiece;
        Field field;

        if (c == '.') {
            return new Field();
        }

        if (Character.isUpperCase(c)) {
            color = ChessPieceColor.BLACK;
            c = Character.toLowerCase(c);
        }
        else {
            color = ChessPieceColor.WHITE;
        }

        type = pieceMap.get(c);

        chessPiece = new ChessPiece(type, color);
        return new Field(chessPiece);
    }
}
