package io.riddles.boardgame.visitor;

import io.riddles.chess.move.ChessMove;
import io.riddles.game.exception.InvalidInputException;

/**
 * io.riddles.boardgame.visitor
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public interface BoardGameMoveDeserializer {

    ChessMove traverse(String input) throws InvalidInputException;
}
