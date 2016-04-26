package io.riddles.chess.move.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Move;
import io.riddles.game.move.MoveValidator;

import java.util.ArrayList;

/**
 * Created by Niko on 26/03/16.
 */
public final class ChessMoveValidator implements MoveValidator {

    private ArrayList<MoveValidator> validators;

    public ChessMoveValidator() {

        ArrayList<MoveValidator> validators = new ArrayList<>();

        validators.add(new FromNotEmptyValidator());
        validators.add(new BishopMoveValidator());
        validators.add(new KingMoveValidator());
        validators.add(new KnightMoveValidator());
        validators.add(new PawnMoveValidator());
        validators.add(new QueenMoveValidator());
        validators.add(new RookMoveValidator());

        this.validators = validators;
    }

    @Override
    public Boolean isApplicable(Move move, Board board) {
        return true;
    }

    @Override
    public Boolean isValid(Move move, Board board) {

        for (MoveValidator validator : validators) {

            if (!validator.isValid(move, board)) {
                return false;
            }
        }

        return true;
    }
}
