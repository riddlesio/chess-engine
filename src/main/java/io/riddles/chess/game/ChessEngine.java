package io.riddles.chess.game;

import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.game.player.ChessPlayer;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.state.ChessPlayerState;
import io.riddles.javainterface.configuration.Configuration;
import io.riddles.javainterface.engine.AbstractEngine;
import io.riddles.javainterface.engine.GameLoopInterface;
import io.riddles.javainterface.exception.TerminalException;
import io.riddles.javainterface.game.player.PlayerProvider;
import io.riddles.javainterface.io.IOHandler;

import java.util.ArrayList;

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

public class ChessEngine extends AbstractEngine<ChessProcessor, ChessPlayer, ChessState> {

    public ChessEngine(PlayerProvider<ChessPlayer> playerProvider, IOHandler ioHandler) throws TerminalException {
        super(playerProvider, ioHandler);
    }

    /* createPlayer creates and initialises a Player for the game.
 * returns: a Player
 */
    @Override
    protected ChessPlayer createPlayer(int id) {
        ChessPlayer p = new ChessPlayer(id);
        return p;
    }

    @Override
    protected Configuration getDefaultConfiguration() {
        Configuration configuration = new Configuration();
        configuration.put("maxRounds", 200); /* Note: in the previous version of Block Battle, maxRounds was set to -1 */
        return configuration;
    }


    /* createProcessor creates and initialises a Processor for the game.
     * returns: a Processor
     */
    @Override
    protected ChessProcessor createProcessor() {

        return new ChessProcessor(playerProvider);
    }

    @Override
    protected GameLoopInterface createGameLoop() {
        return new io.riddles.javainterface.engine.SimpleGameLoop();
    }

    @Override
    protected void sendSettingsToPlayer(ChessPlayer player) {

        String playerNames = "";
        for(ChessPlayer p : playerProvider.getPlayers()) {
            playerNames += p.getName() + ",";
        }
        playerNames = playerNames.substring(0, playerNames.length()-1);

        player.sendSetting("field_height", configuration.getInt("fieldHeight"));
        player.sendSetting("field_width", configuration.getInt("fieldWidth"));
        player.sendSetting("max_rounds", configuration.getInt("maxRounds"));
        player.sendSetting("player_names", playerNames);
        player.sendSetting("your_bot", player.getName());
    }


    /* getPlayedGame creates a serializer and serialises the game
     * returns: String with the serialised game.
     */
    @Override
    protected String getPlayedGame(ChessState state) {
        ChessSerializer serializer = new ChessSerializer();
        return serializer.traverseToString(this.processor, state);
    }

    /* getInitialState creates an initial state to start the game with.
     * returns: ChessState
     */
    @Override
    protected ChessState getInitialState() {
        ArrayList<ChessPlayerState> playerStates = new ArrayList<>();
        ChessBoard board = new ChessBoard(configuration.getInt("fieldWidth"), (configuration.getInt("fieldHeight")));

        for (ChessPlayer player : playerProvider.getPlayers()) {
            ChessPlayerState playerState = new ChessPlayerState(player.getId());
            playerStates.add(playerState);
        }
        ChessState state = new ChessState(null, playerStates, 0);
        return state;
    }
}
