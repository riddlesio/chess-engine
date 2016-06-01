package io.riddles.game.exception;

/**
 * Thrown by the Processor when move is invalid
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko van Meurs <niko@riddles.io>
 */
public class InvalidMoveException extends Exception {

    public InvalidMoveException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Invalid move: " + super.getMessage();
    }
}
