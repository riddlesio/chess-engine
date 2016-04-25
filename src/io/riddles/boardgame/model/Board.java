package io.riddles.boardgame.model;

import java.util.List;

/**
 * Created by Niko on 28/03/16.
 */
public interface Board {

    List<Field> getFields();
    Field getFieldAt(Coordinate coordinate) throws IndexOutOfBoundsException;
    int size();
}
