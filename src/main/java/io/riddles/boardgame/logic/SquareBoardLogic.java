package io.riddles.boardgame.logic;

import io.riddles.boardgame.model.SquareBoard;

/**
 * Contains generic logic for Square boards
 */
public class SquareBoardLogic {

    /**
     * Checks whether the passed coordinate is at the bottom edge of the board
     * @param coordinate
     * @param board
     * @return
     */
    public boolean isCoordinateAtBottomEdge(SquareBoard board, Coordinate coordinate) {

        if (!isWithinBounds(board, coordinate)) {
            return false;
        }

        int boardSize = board.size();
        int y = coordinate.getY();

        return y + 1 == boardSize;
    }

    /**
     * Checks whether the passed coordinate is at the left edge of the board
     * @param coordinate
     * @param board
     * @return
     */
    public boolean isCoordinateAtLeftEdge(SquareBoard board, Coordinate coordinate) {

        if (!isWithinBounds(board, coordinate)) {
            return false;
        }

        int x = coordinate.getX();

        return x == 0;
    }

    /**
     * Checks whether the passed coordinate is at the right edge of the board
     * @param coordinate
     * @param board
     * @return
     */
    public boolean isCoordinateAtRightEdge(SquareBoard board, Coordinate coordinate) {

        if (!isWithinBounds(board, coordinate)) {
            return false;
        }

        int boardSize = board.size();
        int x = coordinate.getX();

        return x + 1 == boardSize;
    }

    /**
     * Checks whether the passed coordinate is at the top edge of the board
     * @param coordinate
     * @param board
     * @return
     */
    public boolean isCoordinateAtTopEdge(SquareBoard board, Coordinate coordinate) {

        if (!isWithinBounds(board, coordinate)) {
            return false;
        }

        int y = coordinate.getY();

        return y == 0;
    }

    /**
     * Checks whether the passed coordinate is within the bounds of the board
     * @param coordinate
     * @param board
     * @return
     */
    public boolean isWithinBounds(SquareBoard board, Coordinate coordinate) {

        int x = coordinate.getX();
        int y = coordinate.getY();
        int size = board.size();

        return isBetween(-1, size, x) && isBetween(-1, size, y);
    }

    /**
     * Checks whether the passed number is between min and max
     * @param min
     * @param max
     * @param number
     * @return
     */
    private boolean isBetween(int min, int max, int number) {

        return min < number && number < max;
    }
}
