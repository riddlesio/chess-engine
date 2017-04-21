package io.riddles.chess.game.processor;

import java.util.ArrayList;

import io.riddles.chess.game.player.ChessPlayer;
import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ActionType;
import io.riddles.chess.move.ChessMove;
import io.riddles.chess.move.ChessMoveDeserializer;
import io.riddles.chess.game.state.ChessPlayerState;
import io.riddles.javainterface.engine.AbstractEngine;
import io.riddles.javainterface.game.player.PlayerProvider;
import io.riddles.javainterface.game.processor.PlayerResponseProcessor;
import io.riddles.javainterface.game.state.AbstractPlayerState;
import io.riddles.javainterface.io.PlayerResponse;

/**
 * io.riddles.Chess.game.processor.ChessProcessor - Created on 6/27/16
 *
 * [description]
 *
 * @author Joost - joost@riddles.io, Jim van Eeden - jim@riddles.io
 */
public class ChessProcessor extends PlayerResponseProcessor<ChessState, ChessPlayer> {

    public ChessProcessor(PlayerProvider<ChessPlayer> playerProvider) {
        super(playerProvider);
    }

    @Override
    public ChessState createNextStateFromResponse(ChessState state, PlayerResponse input, int roundNumber) {

        /* Clone playerStates for next State */
        ArrayList<ChessPlayerState> nextPlayerStates = clonePlayerStates(state.getPlayerStates());
        ChessState nextState = new ChessState(state, nextPlayerStates, roundNumber);
        nextState.setPlayerId(input.getPlayerId());

        ChessMoveDeserializer moveDeserializer = new ChessMoveDeserializer();
        ChessMove move = moveDeserializer.traverse(input.getValue());
        ChessPlayerState playerState = getActivePlayerState(nextPlayerStates, input.getPlayerId());
        playerState.setMove(move);

        if(move.moveType == ChessMove.MoveTypes.Castling  ){
            if( move.isKingCastle() ){
                System.out.println("King side Castling");
            } else {
                System.out.println("Queen side Castling");
            }

        }
        // parse the response
        if (move.getException() != null) {
            System.out.println("EXCEPTION '" + input.getValue() + "' " + move.getException().toString());
        }

        ChessLogic logic = new ChessLogic();
        logic.executeMove(nextState, playerState);

        nextState.getBoard().dump();

        nextState.setPlayerstates((ArrayList)nextPlayerStates);
        return nextState;
    }

    private ChessPlayerState getActivePlayerState(ArrayList<ChessPlayerState> playerStates, int id) {
        for (ChessPlayerState playerState : playerStates) {
            if (playerState.getPlayerId() == id) { return playerState; }
        }
        return null;
    }

    private ArrayList<ChessPlayerState> clonePlayerStates(ArrayList<ChessPlayerState> playerStates) {
        ArrayList<ChessPlayerState> nextPlayerStates = new ArrayList<>();
        for (ChessPlayerState playerState : playerStates) {
            ChessPlayerState nextPlayerState = playerState.clone();
            nextPlayerStates.add(nextPlayerState);
        }
        return nextPlayerStates;
    }


    @Override
    public void sendUpdates(ChessState state, ChessPlayer player) {
        player.sendUpdate("round", state.getRoundNumber());
        player.sendUpdate("field", state.getBoard().toString());
    }


    @Override
    public boolean hasGameEnded(ChessState state) {
        boolean returnVal = false;
        if (state.getRoundNumber() > AbstractEngine.configuration.getInt("maxRounds")) returnVal = true;
        return returnVal;
    }

    /* Returns winner playerId, or null if there's no winner. */
    @Override
    public Integer getWinnerId(ChessState state) {
        return null;
    }

    @Override
    public double getScore(ChessState state) {
        return state.getRoundNumber();
    }

    @Override
    public Enum getActionType(ChessState ChessState, AbstractPlayerState playerState) {
        return ActionType.MOVE;
    }


}
