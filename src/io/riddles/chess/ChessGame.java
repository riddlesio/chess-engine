package io.riddles.chess;

import io.riddles.chess.model.Board;
import io.riddles.chess.model.GameState;
import io.riddles.chess.model.visitor.StateDeserializer;

/**
 * Created by Niko on 24/03/16.
 */
public class ChessGame {

    public ChessGame() {

    }

    public static GameState getInitialState() {

        return new GameState("TNRKQRNT" +
                "PPPPPPPP" +
                "........" +
                "........" +
                "........" +
                "........" +
                "pppppppp" +
                "tnrqkrnt"
        );
    }

    public GameState processCommand(GameState prevState, Command command) {

        GameState nextState;

        StateDeserializer deserializer = new StateDeserializer();
        Board board = deserializer.traverse(prevState.getBoardString());

        try {
            nextState = command.execute(prevState);
        } catch (RuntimeException e) {
            nextState = new GameState(prevState.getBoardString());
            nextState.setException(e);
        }

        return nextState;
    }
}
