package io.riddles.game.io;

/**
 * io.riddles.game.io
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public abstract class AbstractIOProvider {

    private IOHandler handler;

    public AbstractIOProvider(IOHandler handler) {
        this.handler = handler;
    }

    protected IOHandler getHandler() { return handler; }
}
