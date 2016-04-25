package io.riddles.chess.model.visitor;

import io.riddles.boardgame.model.AbstractModel;
import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Field;
import io.riddles.boardgame.model.Piece;
import io.riddles.chess.model.*;
import io.riddles.model.Visitor;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Niko on 24/03/16.
 */
public class StateSerializer implements Visitor {

    private Dictionary<ChessPieceType, Character> pieceMap;
    private String state;

    public StateSerializer() {

        pieceMap = new Hashtable<>();
        pieceMap.put(ChessPieceType.BISHOP, 'b');
        pieceMap.put(ChessPieceType.KING,   'k');
        pieceMap.put(ChessPieceType.KNIGHT, 'n');
        pieceMap.put(ChessPieceType.PAWN,   'p');
        pieceMap.put(ChessPieceType.QUEEN,  'q');
        pieceMap.put(ChessPieceType.ROOK,   'r');
    }

    public String traverse (Board board) {

        state = "";

        this.visit(board);

        return state;
    }

    @Override
    public void visit(AbstractModel model) {}

    public void visit(Board board) {

        board.getFields().forEach(field -> field.accept(this));
    }

    public void visit(Field field) {

        Optional<Piece> maybePiece = field.getPiece();

        maybePiece.ifPresent(piece -> piece.accept(this));

        if (!maybePiece.isPresent()) {
            state += '.';
        }
    }

    public void visit(ChessPiece chessPiece) {

        Character p;
        ChessPieceType type;

        type = chessPiece.getType();
        p    = this.pieceMap.get(type);

        if (ChessPieceColor.BLACK == chessPiece.getColor()) {

            state += Character.toUpperCase(p);
            return;
        }

        state += p;
    }
}
