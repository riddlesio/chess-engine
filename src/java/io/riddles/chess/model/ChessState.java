package io.riddles.chess.model;

import io.riddles.boardgame.model.AbstractModel;
import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.BoardState;
import io.riddles.boardgame.model.Move;
import io.riddles.game.model.Stateful;
import io.riddles.game.model.Traversible;
import io.riddles.game.model.Visitor;

import java.util.Optional;

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
public final class ChessState extends AbstractModel implements Stateful<ChessState>, BoardState, Traversible {

    private Board board;
    private Optional<Exception> exception;
    private Optional<Move> move;
    private int moveNumber;
    private Optional<ChessState> previousState;

    public ChessState(Board board) {

        this.board = board;

        exception       = Optional.empty();
        move            = Optional.empty();
        moveNumber      = -1;
        previousState   = Optional.empty();
    }

    public ChessState(ChessState previousState, Exception exception) {

        this.exception      = Optional.of(exception);
        this.previousState  = Optional.of(previousState);

        board       = previousState.getBoard();
        move        = Optional.empty();
        moveNumber  = previousState.getMoveNumber();
    }

    public ChessState(ChessState previousState, Board board, Move move) {

        this.board          = board;
        this.previousState  = Optional.of(previousState);
        this.move           = Optional.of(move);

        exception      = Optional.empty();
        moveNumber     = previousState.getMoveNumber() + 1;
    }

    public Board getBoard() { return board; }

    @Override
    public Optional<Move> getMove() {
        return move;
    }

    @Override
    public Optional<Exception> getException() {
        return exception;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    @Override
    public Optional<ChessState> getPreviousState() {
        return previousState;
    }

    public Boolean hasException() {

        return exception.map(exception -> true).orElse(false);
    }

    public Boolean hasMove() {

        return move.map(move -> true).orElse(false);
    }

    public Boolean hasPreviousState() {

        return previousState.map(previousState -> true).orElse(false);
    }
}
