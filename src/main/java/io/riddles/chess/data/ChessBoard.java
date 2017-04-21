package io.riddles.chess.data;

import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ChessPieceType;
import io.riddles.javainterface.game.data.Board;


/**
 * Created by joost on 4/18/17.
 */
public class ChessBoard extends Board<ChessPiece>{
    protected int width = 19;
    protected int height = 19;
    public static final String EMPTY_FIELD = ".";


    public ChessBoard(int width, int height) {
        super(width, height);

        fields = new ChessPiece[width][height];
        clear();
    }

    public ChessBoard(int width, int height, String initialBoard) {
        super(width, height);

        fields = new ChessPiece[width][height];
        clear();
        setFieldsFromString(initialBoard);
    }

    public ChessBoard(ChessBoard board) {
        super(board.getWidth(), board.getHeight());
        fields = new ChessPiece[width][height];
        clear();
        setFieldsFromString(board.toString());
    }


    public void clear() {
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                fields[x][y] = null;
            }
        }
    }

    public void setFieldsFromString(String input) {
        String[] split = input.split(",");
        int x = 0;
        int y = 0;
        this.fields = new ChessPiece[width][height];
        for(int c = 0; c < split.length; c++) {
            String fieldString = split[c];
            this.fields[x][y] = this.fieldFromString(fieldString);
            x++;

            if(x == this.width) {
                x = 0;
                y++;
            }
        }
    }

    /* Return a Piece, or null if unable to parse or empty. */
    public ChessPiece fieldFromString(String input) {
        switch (input) {
            case "R":
                return new ChessPiece(ChessPieceType.ROOK, ChessPieceColor.BLACK);
            case "N":
                return new ChessPiece(ChessPieceType.KNIGHT, ChessPieceColor.BLACK);
            case "B":
                return new ChessPiece(ChessPieceType.BISHOP, ChessPieceColor.BLACK);
            case "K":
                return new ChessPiece(ChessPieceType.KING, ChessPieceColor.BLACK);
            case "Q":
                return new ChessPiece(ChessPieceType.QUEEN, ChessPieceColor.BLACK);
            case "P":
                return new ChessPiece(ChessPieceType.PAWN, ChessPieceColor.BLACK);
            case "r":
                return new ChessPiece(ChessPieceType.ROOK, ChessPieceColor.WHITE);
            case "n":
                return new ChessPiece(ChessPieceType.KNIGHT, ChessPieceColor.WHITE);
            case "b":
                return new ChessPiece(ChessPieceType.BISHOP, ChessPieceColor.WHITE);
            case "k":
                return new ChessPiece(ChessPieceType.KING, ChessPieceColor.WHITE);
            case "q":
                return new ChessPiece(ChessPieceType.QUEEN, ChessPieceColor.WHITE);
            case "p":
                return new ChessPiece(ChessPieceType.PAWN, ChessPieceColor.WHITE);
            case ".":
                return null;
        }
        return null;
    }

    public String getStringFromFrield(ChessPiece p) {
        ChessPieceType type = p.getType();
        if (p.getColor() == ChessPieceColor.BLACK) {
            switch (p.getType()) {
                case ROOK:
                    return "R";
                case KNIGHT:
                    return "N";
                case BISHOP:
                    return "B";
                case KING:
                    return "K";
                case QUEEN:
                    return "Q";
                case PAWN:
                    return "P";
            }
        } else {
            switch (p.getType()) {
                case ROOK:
                    return "r";
                case KNIGHT:
                    return "n";
                case BISHOP:
                    return "b";
                case KING:
                    return "k";
                case QUEEN:
                    return "q";
                case PAWN:
                    return "p";
            }
        }
        return ".";
    }

    public String toString() {
        String s = "";
        int counter = 0;
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                if (counter > 0)
                    s += ",";
                s += getStringFromFrield(this.fields[x][y]);
                counter++;
            }
        }
        return s;
    }
}
