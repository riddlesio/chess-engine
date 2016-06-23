package io.riddles.chess;

import io.riddles.chess.game.ChessGameEngine;

public class Main {

    public static void main(String[] args) {
        // write your code here
    	
    	ChessGameEngine chessengine = new ChessGameEngine();
    	chessengine.run(ChessGameEngine.getInitialStateString());
    	
    	
    }
}
