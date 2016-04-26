package io.riddles.game.engine;

import io.riddles.game.io.Command;
import io.riddles.game.io.IO;

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
public class SimpleGameLoop<State> implements GameLoop<State> {

    public State run(IO io, Processor<State> processor, State initialState) {

        Command command;
        String input;
        State state = initialState;

        while (!processor.hasGameEnded(state)) {

            command = processor.getCommand(state);
            input = io.execute(command);

            try {
                state = processor.processInput(input, state);

            } catch (Exception exception) {

                state = processor.processException(exception, state);
            }
        }

        return state;
    }
}
