package io.riddles.boardgame.transformer;

import io.riddles.chess.move.ChessMove;

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

    ChessMove transform(State state, Transformable source) throws IllegalArgumentException;
    Transformable reverseTransform(ChessMove move) throws IllegalArgumentException;
}
