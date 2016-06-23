package io.riddles.chess.game;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Move.MoveTypes;
import io.riddles.boardgame.visitor.BoardGameMoveDeserializer;
import io.riddles.boardgame.visitor.SimpleBoardGameMoveDeserializer;
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
    public ChessState processInputTest(ChessState state, String input) throws Exception {

        System.out.println("testing input");    	
        //System.out.flush();    	
        MoveValidator validator = new ChessMoveValidator();

        Board board = state.getBoard();

        BoardGameMoveDeserializer moveDeserializer = new SimpleBoardGameMoveDeserializer();
        Move move = moveDeserializer.traverse(input);

        //test input
        if(  move.moveType == MoveTypes.Regular  ){
          System.out.println(move.getFrom().getX());
          System.out.println(move.getFrom().getY());        
        
          System.out.println(move.getTo().getX());
          System.out.println(move.getTo().getY()); 
        }
        
        
        if(  move.moveType == MoveTypes.Promotion  ){
          System.out.println(move.getFrom().getX());
          System.out.println(move.getFrom().getY());        
        
          System.out.println(move.getTo().getX());
          System.out.println(move.getTo().getY()); 
          System.out.println(move.getPromotionType());           
        }
                
        
        if(  move.moveType == MoveTypes.Castling  ){
         	if( move.isKingCastle() ){
              System.out.println("King side Castling"); 
        	} else {
                System.out.println("Queen side Castling");         		
        	}
                  
        }
        
        if (!validator.isValid(move, board, state)) {
            // FIXME: throw a more descriptive error
            throw new InvalidMoveException("Move not valid");
        }

        return new ChessState(state, board, move);
    }
    
       
    
    @Override
    public ChessState processInput(ChessState state, IOResponse input) throws Exception {

        MoveValidator validator = new ChessMoveValidator();

        Board board = state.getBoard();

        BoardGameMoveDeserializer moveDeserializer = new SimpleBoardGameMoveDeserializer();
        Move move = moveDeserializer.traverse(input.getValue());

        if (!validator.isValid(move, board,state)) {
            // FIXME: throw a more descriptive error
            throw new InvalidMoveException("Move not valid");
        }

        return new ChessState(state, board, move);
    }
    
    
}
