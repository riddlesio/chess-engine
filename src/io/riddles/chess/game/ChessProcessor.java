package io.riddles.chess.game;

import io.riddles.chess.model.ChessState;
import io.riddles.game.engine.Processor;
import io.riddles.game.io.Command;

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
        return null;
    }

    @Override
    public boolean hasGameEnded(ChessState state) {
        return false;
    }

    @Override
    public ChessState processException(Exception exception, ChessState state) {

        return ChessState.of(exception, state);
    }

    @Override
    public ChessState processInput(String input, ChessState state) {
        return state;
    }
}
