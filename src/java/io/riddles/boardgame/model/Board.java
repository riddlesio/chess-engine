package io.riddles.boardgame.model;

import io.riddles.game.model.Traversible;

import java.util.List;

/**
 * ${PACKAGE_NAME}
 *
 * This file is a part of chess
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public interface Board extends Traversible {

    List<Field> getFields();
    Field getFieldAt(Coordinate coordinate) throws IndexOutOfBoundsException;
    int size();
}
