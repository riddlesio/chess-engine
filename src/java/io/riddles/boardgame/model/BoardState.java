package io.riddles.boardgame.model;

import java.util.Optional;

/**
 * io.riddles.boardgame.model
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public interface BoardState {

    Board getBoard();
    Optional<Move> getMove();
}
