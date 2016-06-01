package io.riddles.game.exception;

/**
 * Thrown by Processor.processInput when input cannot be parsed
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko van Meurs <niko@riddles.io>
 */
public class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Invalid input: " + super.getMessage();
    }
}
