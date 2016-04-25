package io.riddles.chess.move.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Piece;
import io.riddles.chess.model.ChessPieceType;

import java.util.Optional;

/**
 * Created by Niko on 28/03/16.
 */
public abstract class ChessPieceMoveValidator {

    protected Boolean isMovedPieceOfType(Move move, Board board, ChessPieceType type) {

        Coordinate from = move.getFrom();
        Optional<Piece> piece = board.getFieldAt(from).getPiece();

        return piece.map(p -> p.hasType(type)).orElse(false);
    }
}
