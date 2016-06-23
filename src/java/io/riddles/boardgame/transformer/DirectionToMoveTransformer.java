package io.riddles.boardgame.transformer;

import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Direction;

import java.util.function.Function;

import static io.riddles.boardgame.model.Direction.*;

/**
 * io.riddles.boardgame.transformer
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko van Meurs <niko@riddles.io>
 */
public final class DirectionToMoveTransformer<State> implements MoveTransformer<State, Direction> {

    private Function<State, Coordinate> getFromCoordinate;

    /**
     * Offers transformation and reverse transformation of (State, Direction) <> Move
     * @param getFromCoordinate Function which takes a state and returns a move's source
     *                          coordinate.
     */
    public DirectionToMoveTransformer(Function<State, Coordinate> getFromCoordinate) {

        this.getFromCoordinate = getFromCoordinate;
    }

    /**
     * Returns a move with absolute coordinates based on a given State and Direction
     * @param state  The input state from which a source coordinate can be derived
     * @param source The direction which can be used to derive the target coordinate
     *               relative to the source coordinate
     * @return Move
     */
    @Override
    public Move transform(State state, Direction source) {

        Coordinate from = getFromCoordinate.apply(state);
        Coordinate to;

        switch (source) {
            case UP:
                to = new Coordinate(from.getX(), from.getY() - 1);
                return new Move(from, to);
            case DOWN:
                to = new Coordinate(from.getX(), from.getY() + 1);
                return new Move(from, to);
            case LEFT:
                to = new Coordinate(from.getX() - 1, from.getY());
                return new Move(from, to);
            case RIGHT:
                to = new Coordinate(from.getX() + 1, from.getY());
                return new Move(from, to);
        }

        throw new IllegalArgumentException("Move cannot be derived from Direction");
    }

    /**
     * Returns the Direction for a given move
     * @param move The move for which to return a Direction relative to the source coordinate
     * @return Direction
     */
    @Override
    public Direction reverseTransform(Move move) {

        Coordinate from = move.getFrom();
        Coordinate to = move.getTo();

        int fromX = from.getX();
        int fromY = from.getY();
        int toX = to.getX();
        int toY = to.getY();

        int deltaX = fromX - toX;
        int deltaY = fromY - toY;

        if (deltaX == 0 && deltaY > 0) {
            return DOWN;
        }

        if (deltaX == 0 && deltaY < 0) {
            return UP;
        }

        if (deltaX > 0 && deltaY == 0) {
            return RIGHT;
        }

        if (deltaX < 0 && deltaY == 0) {
            return LEFT;
        }

        throw new IllegalArgumentException("Direction cannot be derived from Move");
    }
}
