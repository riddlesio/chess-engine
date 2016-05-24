package io.riddles.boardgame.transformer;

import io.riddles.boardgame.model.Move;

/**
 * io.riddles.boardgame.transformer
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public interface MoveTransformer<State, Transformable> {

    Move transform(State state, Transformable source);
    Transformable reverseTransform(Move move);
}
