package io.riddles.game.engine;

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

    State processException(Exception exception, State state);
    State processInput(String input, State state);
}
