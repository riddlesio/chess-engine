package io.riddles.chess.game;

import io.riddles.chess.model.ChessState;
import io.riddles.chess.model.visitor.ChessStateDeserializer;
import io.riddles.game.engine.GameEngine;
import io.riddles.game.engine.GameLoop;
import io.riddles.game.engine.Processor;
import io.riddles.game.engine.SimpleGameLoop;

/**
 * Created by Niko on 24/03/16.
 */
public class ChessGameEngine implements GameEngine {

    private GameLoop<ChessState> gameLoop;
    private Processor<ChessState> processor;
    private ChessState initialState;
    private ChessState finalState;

    public ChessGameEngine() {

        gameLoop  = new SimpleGameLoop<>();
        processor = new ChessProcessor();
    }

    public void run(String initialStateString) {

        ChessStateDeserializer deserializer = new ChessStateDeserializer();
        ChessState initialState = deserializer.traverse(initialStateString);
        // TODO: implement io
        finalState = gameLoop.run(io, processor, initialState);
    }

    public static String getInitialStateString() {

        return "TNRKQRNT" +
               "PPPPPPPP" +
               "........" +
               "........" +
               "........" +
               "........" +
               "pppppppp" +
               "tnrqkrnt";
    }
}
