package io.riddles.chess.game;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.visitor.BoardGameMoveDeserializer;
import io.riddles.boardgame.visitor.SimpleBoardGameMoveDeserializer;
import io.riddles.chess.io.ChessIORequest;
import io.riddles.chess.io.ChessIORequestType;
import io.riddles.chess.model.ChessState;
import io.riddles.chess.transformer.ChessStateToIORequestTransformer;
import io.riddles.chess.validator.ChessMoveValidator;
import io.riddles.game.engine.Processor;
import io.riddles.game.exception.InvalidMoveException;
import io.riddles.game.io.IORequest;
import io.riddles.game.io.IOResponse;
import io.riddles.game.validator.MoveValidator;

/**
 * This class is the connects the Chess game with the encapsulating
 * framework. It should implement all methods required for the
 * Riddles.io framework to retrieve the necessary game data.
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko van Meurs <niko@riddles.io>
 */
public class ChessProcessor implements Processor<ChessState> {

    @Override
    public IORequest getRequest(ChessState state) {

        ChessStateToIORequestTransformer transformer = new ChessStateToIORequestTransformer();
        return transformer.transform(state);
    }

    @Override
    public boolean hasGameEnded(ChessState state) {
        // TODO: implement
        return false;
    }

    @Override
    public ChessState processException(ChessState state, Exception exception) {

        return new ChessState(state, exception);
    }

    @Override
    public ChessState processInput(ChessState state, IOResponse input) throws Exception {

        MoveValidator validator = new ChessMoveValidator();

        Board board = state.getBoard();

        BoardGameMoveDeserializer moveDeserializer = new SimpleBoardGameMoveDeserializer();
        Move move = moveDeserializer.traverse(input.getValue());

        if (!validator.isValid(move, board)) {
            // FIXME: throw a more descriptive error
            throw new InvalidMoveException("Move not valid");
        }

        return new ChessState(state, board, move);
    }
}
