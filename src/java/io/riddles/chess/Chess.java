package io.riddles.chess;

import io.riddles.chess.game.ChessEngine;

public class giChess {

    public static void main(String[] args) throws Exception {
        ChessEngine engine;
        engine = new ChessEngine(new PlayerProvider<>(), new IOHandler());

        ChessState initialState = engine.willRun();
        ChessState finalState = engine.run(initialState);
        engine.didRun(initialState, finalState);
    }
}
