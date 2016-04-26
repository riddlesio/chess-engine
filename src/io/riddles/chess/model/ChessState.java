package io.riddles.chess.model;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.BoardState;
import io.riddles.boardgame.model.Move;
import io.riddles.model.Stateful;
import io.riddles.model.Traversible;
import io.riddles.model.Visitor;

import java.util.Optional;

/**
 * Created by Niko on 24/03/16.
 */
public final class ChessState implements Stateful<ChessState>, BoardState, Traversible {

    private Board board;
    private Optional<Exception> exception;
    private Optional<Move> move;
    private int moveNumber;
    private Optional<ChessState> previousState;

    private ChessState(Board board) {

        this.board = board;

        exception       = Optional.empty();
        move            = Optional.empty();
        moveNumber      = -1;
        previousState   = Optional.empty();
    }

    private ChessState(ChessState previousState, Exception exception) {

        this.exception      = Optional.of(exception);
        this.previousState  = Optional.of(previousState);

        board       = previousState.getBoard();
        move        = Optional.empty();
        moveNumber  = previousState.getMoveNumber();
    }

    private ChessState(ChessState previousState, Board board, Move move) {

        this.board          = board;
        this.previousState  = Optional.of(previousState);
        this.move           = Optional.of(move);

        exception      = Optional.empty();
        moveNumber     = previousState.getMoveNumber() + 1;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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

    public static ChessState of (Board board) {

        return new ChessState(board);
    }

    public static ChessState of (ChessState previousState, Exception exception) {

        return new ChessState(previousState, exception);
    }

    public static ChessState of (ChessState previousState, Board board, Move move) {

        return new ChessState(previousState, board, move);
    }
}
