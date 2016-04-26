package io.riddles.chess.move.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Move;
import io.riddles.chess.model.*;
import io.riddles.game.move.MoveValidator;

/**
 * Created by Niko on 26/03/16.
 */
public class QueenMoveValidator extends ChessPieceMoveValidator implements MoveValidator {

    @Override
    public Boolean isApplicable(Move move, Board board) {

        return this.isMovedPieceOfType(move, board, ChessPieceType.QUEEN);
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        MoveValidator bishopMoveValidator = new BishopMoveValidator();
        MoveValidator rookMoveValidator = new RookMoveValidator();

        Boolean isValidBishopMove = bishopMoveValidator.isValid(move, board);
        Boolean isValidRookMove = rookMoveValidator.isValid(move, board);

        return isValidBishopMove || isValidRookMove;

//        throw new IllegalMoveException("The queen can only move horizontally, vertically or diagonally");
    }
}
