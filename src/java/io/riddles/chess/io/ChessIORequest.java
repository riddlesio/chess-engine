package io.riddles.chess.io;

import io.riddles.boardgame.model.Coordinate;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.game.io.IORequest;
import io.riddles.game.model.Traversible;
import io.riddles.game.model.Visitor;

import java.util.Optional;

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
public class ChessIORequest implements Traversible, IORequest {

    private ChessIORequestType type;
    private ChessPieceColor color;
    private Optional<Coordinate> coordinate;

    public ChessIORequest(ChessPieceColor color, ChessIORequestType type) {
        coordinate = Optional.empty();
        this.color = color;
        this.type = type;
    }

    public ChessIORequest(ChessPieceColor color, ChessIORequestType type, Coordinate coordinate) {
        this.color = color;
        this.coordinate = Optional.of(coordinate);
        this.type = type;
    }

    public ChessPieceColor getColor() { return color; }

    @Override
    public ChessIORequestType getType() {
        return type;
    }

    public Optional<Coordinate> getCoordinate() {
        return coordinate;
    }

    @Override
    public <ReturnType> ReturnType accept(Visitor<ReturnType> visitor) {
        return visitor.visit(this);
    }
}
