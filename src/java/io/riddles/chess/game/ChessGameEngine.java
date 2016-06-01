package io.riddles.chess.game;

import io.riddles.chess.model.ChessState;
import io.riddles.chess.visitor.ChessStateDeserializer;
import io.riddles.game.engine.GameEngine;
import io.riddles.game.engine.GameLoop;
import io.riddles.game.engine.Processor;
import io.riddles.game.engine.SimpleGameLoop;

/**
 * This class is the connecting instance between the Chess game and the
 * encapsulating framework. It should implement all methods required for
 * the Riddles.io framework to retrieve the necessary game data.
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko van Meurs <niko@riddles.io>
 */
public class ChessGameEngine implements GameEngine {

    private GameLoop<ChessState> gameLoop;
    private Processor<ChessState> processor;
    private ChessState finalState;

    public ChessGameEngine() {

        gameLoop  = new SimpleGameLoop<>();
        processor = new ChessProcessor();
    }

    /**
     * Deserializes the initialState string and runs the GameLoop
     *
     * @param initialStateString - String representation of the initial State
     */
    public void run(String initialStateString) {

        ChessStateDeserializer deserializer = new ChessStateDeserializer();
        ChessState initialState = deserializer.traverse(initialStateString);
        // TODO: implement io
        finalState = gameLoop.run(null, processor, initialState);
    }

    /**
     * TODO: expose all functions necessary to have the match data
     *       consumed by the Riddles.io and TheAIGames libraries.
     */

    /**
     * Exposes the default initial state representation. Can be used by
     * the encapsulating process if no initial state has been provided.
     *
     * @return {String}
     */
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
