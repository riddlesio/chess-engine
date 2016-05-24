package io.riddles.chess.visitor;

import io.riddles.chess.io.ChessIORequest;

/**
 * io.riddles.chess.visitor
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public class ChessIOResponseSerializer {

    public ChessIOResponse traverse(String input, ChessIORequest request) {

        ChessIOResponse response = new ChessIOResponse(input, request);
    }
}
