package io.riddles.chess;

import io.riddles.chess.game.ChessEngine;
import io.riddles.chess.model.ChessState;
import io.riddles.game.io.IOHandler;

public class Chess {

    public static void main(String[] args) {

        ChessEngine engine;
        engine = new ChessEngine(new PlayerProvider<ChessEngine>(), new IOHandler());

        ChessState initialState = engine.willRun();
        ChessState finalState = engine.run(initialState);
        engine.didRun(initialState, finalState);
    }
}
