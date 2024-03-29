package io.riddles.chess.validator;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Field;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Piece;
import io.riddles.boardgame.model.Piece.PieceColor;
import io.riddles.chess.model.ChessPieceType;
import io.riddles.chess.model.ChessState;
import io.riddles.game.validator.MoveValidator;

import java.util.ArrayList;
import java.util.Optional;

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
public final class ChessMoveValidator implements MoveValidator {

    private ArrayList<MoveValidator> validators;

    public ChessMoveValidator() {

        ArrayList<MoveValidator> validators = new ArrayList<>();

        validators.add(new FromNotEmptyValidator());
        validators.add(new BishopMoveValidator());
        validators.add(new KingMoveValidator());
        validators.add(new KnightMoveValidator());
        validators.add(new PawnMoveValidator());
        validators.add(new QueenMoveValidator());
        validators.add(new RookMoveValidator());

        this.validators = validators;
    }

    @Override
    public Boolean isApplicable(Move move, Board board) {
        return true;
    }

    @Override
    public Boolean isValid(Move move, Board board, ChessState state) {

    	//first check if the move is valid
    	MoveValidator notEmpty = new FromNotEmptyValidator();
        if (!notEmpty.isValid(move, board, state)) {
            return false;
        }    	
    	
        //get the piece at the from location
        Coordinate from = move.getFrom();
        Field field = board.getFieldAt(from);
        Optional<Piece> fromPiece = field.getPiece();  
        PieceColor toMove = PieceColor.WHITE;
        //state.getMoveNumber() starts with -1
        if (state.getMoveNumber() > 0 && state.getMoveNumber() % 2 == 0){ 
        	toMove = PieceColor.BLACK;
        }
        //check if we move a piece of the current player
        if ( toMove != fromPiece.get().getColor() ){ 
        	return false;
        }
        ChessPieceType getPieceType = (ChessPieceType) fromPiece.get().getType();
        switch( getPieceType ){
          case BISHOP: 
        	  MoveValidator validatorBishop = new BishopMoveValidator();
              if (!validatorBishop.isValid(move, board, state)) {
                  return false;
              }    
        	  break;
          case ROOK: 
        	  MoveValidator validatorRook = new RookMoveValidator();
              if (!validatorRook.isValid(move, board, state)) {
                  return false;
              }    
        	  break;
          case KNIGHT: 
        	  MoveValidator validatorKnight = new KnightMoveValidator();
              if (!validatorKnight.isValid(move, board, state)) {
                  return false;
              }    
        	  break;
          case PAWN: 
        	  MoveValidator validatorPawn = new PawnMoveValidator();
              if (!validatorPawn.isValid(move, board, state)) {
                  return false;
              }    
        	  break;
          case QUEEN: 
        	  MoveValidator validatorQueen = new QueenMoveValidator();
              if (!validatorQueen.isValid(move, board, state)) {
                  return false;
              }    
        	  break;
          case KING: 
        	  MoveValidator validatorKing = new KingMoveValidator();
              if (!validatorKing.isValid(move, board, state)) {
                  return false;
              }    
        	  break;        	       	          	     
        	  
        }
        
        /*
        for (MoveValidator validator : validators) {

            if (!validator.isValid(move, board)) {
                return false;
            }
        }
        */
        
        return true;
    }
}
