package io.riddles.chess;

import io.riddles.chess.engine.ChessEngine;
import io.riddles.chess.game.state.ChessState;
import io.riddles.javainterface.game.player.PlayerProvider;
import io.riddles.javainterface.io.IOHandler;

public class Chess {

    public static void main(String[] args) throws Exception {

        ChessEngine engine;
        engine = new ChessEngine(new PlayerProvider<>(), new IOHandler());

        ChessState initialState = engine.willRun();
        ChessState finalState = engine.run(initialState);
        engine.didRun(initialState, finalState);
    }
}
