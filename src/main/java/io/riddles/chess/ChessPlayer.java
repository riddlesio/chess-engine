package io.riddles.chess;

import io.riddles.javainterface.game.player.AbstractPlayer;

/**
 * Created by joost on 4/18/17.
 */
public class ChessPlayer extends AbstractPlayer {




    public ChessPlayer(int id) {
        super(id);
    }

    public String toString() {
        return "ChessPlayer " + this.getId();
    }


}
