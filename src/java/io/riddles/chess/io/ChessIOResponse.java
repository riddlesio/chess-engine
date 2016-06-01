package io.riddles.chess.io;

import io.riddles.game.io.IORequest;
import io.riddles.game.io.IOResponse;

/**
 * io.riddles.chess.io
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public class ChessIOResponse implements IOResponse {

    IORequest request;

    public ChessIOResponse(String input, IORequest request) {
        this.request = request;
    }

    @Override
    public IORequest getRequest() {
        return request;
    }

    @Override
    public String getValue() {
        return null;
    }
}
