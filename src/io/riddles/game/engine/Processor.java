package io.riddles.game.engine;

import io.riddles.game.exception.InvalidMoveException;
import io.riddles.game.io.Command;

/**
 * io.riddles.game.engine
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public interface Processor<State> {

    Command getCommand(State state);

    boolean hasGameEnded(State state);

    State processException(State state, Exception exception);
    State processInput(State state, String input) throws InvalidMoveException;
}
