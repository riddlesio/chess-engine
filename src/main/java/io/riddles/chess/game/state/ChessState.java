package io.riddles.chess.game.state;

import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.state.ChessPlayerState;
import io.riddles.javainterface.game.player.PlayerBound;
import io.riddles.javainterface.game.state.AbstractState;

import java.util.ArrayList;

/**
 * ${PACKAGE_NAME}
 *
 * This file is a part of chess
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public final class ChessState extends AbstractState<ChessPlayerState> implements PlayerBound {

    private ChessBoard board;
    private int playerId;

    public ChessState(ChessState previousState, ArrayList<ChessPlayerState> playerStates, int roundNumber) {
        super(previousState, playerStates, roundNumber);
        this.board = new ChessBoard(previousState.getBoard());
    }

    public ChessBoard getBoard() { return board; }

    @Override
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int id) { this.playerId = id; }
}
