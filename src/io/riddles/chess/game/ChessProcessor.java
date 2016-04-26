package io.riddles.chess.game;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Move;
import io.riddles.chess.model.ChessState;
import io.riddles.chess.move.validator.ChessMoveValidator;
import io.riddles.game.engine.Processor;
import io.riddles.game.exception.InvalidMoveException;
import io.riddles.game.io.Command;
import io.riddles.game.move.MoveValidator;

/**
 * io.riddles.chess.game
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public class ChessProcessor implements Processor<ChessState> {

    @Override
    public Command getCommand(ChessState state) {
        // TODO: implement
        return null;
    }

    @Override
    public boolean hasGameEnded(ChessState state) {
        // TODO: implement
        return false;
    }

    @Override
    public ChessState processException(ChessState state, Exception exception) {

        return new ChessState(state, exception);
    }

    @Override
    public ChessState processInput(ChessState state, String input) throws InvalidMoveException {

        MoveValidator validator = new ChessMoveValidator();

        Board board = state.getBoard();
        // TODO: implement parser
        Move move; = parser.parseInput(input);

        if (!validator.isValid(move, board)) {
            // FIXME: throw a more descriptive error
            throw new InvalidMoveException("Move not valid");
        }

        return new ChessState(state, board, move);
    }
}
