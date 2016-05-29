package io.riddles.boardgame.logic;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.SquareBoard;

/**
 * Created by Niko on 29/05/16.
 */
public class SquareBoardLogic {

    public boolean isCoordinateAtBottomEdge(Coordinate coordinate, SquareBoard board) {

        int boardSize = board.size();
        return boardSize == coordinate.getY() + 1;
    }

    public boolean isCoordinateAtLeftEdge(Coordinate coordinate, SquareBoard board) {

        return 0 == coordinate.getX();
    }

    public boolean isCoordinateAtRightEdge(Coordinate coordinate, SquareBoard board) {

        int boardSize = board.size();
        return boardSize == coordinate.getX() + 1;
    }

    public boolean isCoordinateAtTopEdge(Coordinate coordinate, SquareBoard board) {

        return 0 == coordinate.getY();
    }
}
