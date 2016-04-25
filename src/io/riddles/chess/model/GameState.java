package io.riddles.chess.model;

/**
 * Created by Niko on 24/03/16.
 */
public class GameState {

    private Exception exception;
    private String boardString;

    public GameState(String boardString) {

        this.boardString = boardString;
        exception = null;
    }

    public String getBoardString() {

        return boardString;
    }

    public Boolean hasException() {

        return exception != null;
    }

    public Exception getException() {
        return this.exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
