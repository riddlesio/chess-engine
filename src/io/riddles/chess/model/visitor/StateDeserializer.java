package io.riddles.chess.model.visitor;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Field;
import io.riddles.boardgame.model.Piece;
import io.riddles.boardgame.model.SquareBoard;
import io.riddles.chess.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by Niko on 24/03/16.
 */
public class StateDeserializer {

    private HashMap<Character, ChessPieceType> pieceMap;

    public StateDeserializer () {

        pieceMap = new HashMap<>();
        pieceMap.put('b', ChessPieceType.BISHOP);
        pieceMap.put('k', ChessPieceType.KING);
        pieceMap.put('n', ChessPieceType.KNIGHT);
        pieceMap.put('p', ChessPieceType.PAWN);
        pieceMap.put('q', ChessPieceType.QUEEN);
        pieceMap.put('r', ChessPieceType.ROOK);
    }

    public Board traverse (String state) {

        return this.visit(state);
    }

    private Board visit(String state) {

        ArrayList<Field> fields = new ArrayList<>();

        for (Character character : state.toCharArray()) {
            fields.add(this.visit(character));
        }

        return SquareBoard.of(fields);
    }

    private Field visit(Character c) {

        ChessPiece chessPiece;
        ChessPieceColor color;
        ChessPieceType type;

        if ('.' != c) {

            if (Character.isUpperCase(c)) {
                color = ChessPieceColor.BLACK;
                c = Character.toLowerCase(c);
            }
            else {
                color = ChessPieceColor.WHITE;
            }

            type = pieceMap.get(c);

            chessPiece = ChessPiece.of(type, color);
        }

        Optional<Piece> maybePiece = Optional.ofNullable(chessPiece);

        return Field.of(maybePiece);
    }
}
