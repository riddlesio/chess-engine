package io.riddles.chess.game;

import io.riddles.chess.model.ChessState;
import io.riddles.game.engine.GameLoop;
import io.riddles.game.engine.Processor;
import io.riddles.game.engine.SimpleGameLoop;

/**
 * Created by Niko on 24/03/16.
 */
public class ChessGame {

    private GameLoop<ChessState> gameLoop;
    private Processor<ChessState> processor;
    private ChessState finalState;

    public ChessGame() {

        gameLoop  = new SimpleGameLoop<>();
        processor = new ChessProcessor();
    }

    public void run() {

//        finalState = gameLoop.run(io, processor, initialState);
    }

    public static ChessState getInitialState() {

        return new ChessState("TNRKQRNT" +
                "PPPPPPPP" +
                "........" +
                "........" +
                "........" +
                "........" +
                "pppppppp" +
                "tnrqkrnt"
        );
    }
}
