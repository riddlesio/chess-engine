package io.riddles.game.engine;

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
public interface GameLoop<State> {

    State run(IO io, Processor<State> processor, State initialState);
}