package io.riddles.chess.visitor;

import com.sun.javaws.exceptions.InvalidArgumentException;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.chess.io.ChessIORequest;
import io.riddles.game.model.Traversible;
import io.riddles.game.model.Visitor;

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
public class ChessIORequestSerializer implements Visitor<String> {

    private String result;

    public ChessIORequestSerializer() {
        result = "";
    }

    public String traverse(ChessIORequest request) {
        return request.accept(this);
    }

    public String visit(ChessIORequest request) throws Exception {

        Coordinate coordinate;

        switch (request.getType()) {

            case MOVE:
                return "MOVE";

            case PROMOTE:
                coordinate = request.getCoordinate().get();
                return String.format("PROMOTE %s", coordinate.accept(this));
        }

        throw new Exception("Could not parse IORequest");
    }

    public String visit(Coordinate coordinate) {

        int x = coordinate.getX();
        int y = coordinate.getY();

        return String.format("%d,%d", x, y);
    }

    @Override
    public String visit(Traversible traversible) { return ""; }
}
