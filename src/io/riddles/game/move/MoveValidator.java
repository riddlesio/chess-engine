package io.riddles.game.move;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Move;

/**
 * Created by Niko on 26/03/16.
 */
public interface MoveValidator {

    Boolean isApplicable(Move move, Board board);

    Boolean isValid(Move move, Board board);
}
