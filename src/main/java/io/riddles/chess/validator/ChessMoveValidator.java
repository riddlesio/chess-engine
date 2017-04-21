package io.riddles.chess.validator;

import io.riddles.chess.model.ValidationResult;
import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.data.ChessPiece;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ChessPieceType;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.move.ChessMove;

import java.awt.*;
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
public final class ChessMoveValidator implements MoveValidator<ChessState> {

    public ChessMoveValidator() {
    }

    @Override
    public Boolean isApplicable(ChessMove move, ChessState state) {
        return true;
    }

    @Override
    public ValidationResult validate(ChessMove move, ChessState state) {
        ChessBoard board = state.getBoard();

    	//first check if the move is valid
    	MoveValidator notEmpty = new FromNotEmptyValidator();
        if (!notEmpty.validate(move, board).isValid()) {
            return new ValidationResult(false, "From field is empty.");
        }    	
    	
        //get the piece at the from location
        Point from = move.getFrom();
        ChessPiece fromPiece = board.getFieldAt(from);

        ChessPieceColor moveColor = ChessPieceColor.WHITE;
        if (state.getRoundNumber() > 0 && state.getRoundNumber() % 2 == 0){
            moveColor = ChessPieceColor.BLACK;
        }
        //check if we move a piece of the current player
        if ( moveColor != fromPiece.getColor() ){
        	return new ValidationResult(false, "Move isn't the right color piece.");
        }
        ChessPieceType pieceType = fromPiece.getType();
        MoveValidator validator = null;
        switch( pieceType ){
          case BISHOP: 
        	  validator = new BishopMoveValidator();
        	  break;
          case ROOK: 
        	  validator = new RookMoveValidator();
              break;
          case KNIGHT: 
        	  validator = new KnightMoveValidator();
              break;
          case PAWN: 
        	  validator = new PawnMoveValidator();
              break;
          case QUEEN: 
        	  validator = new QueenMoveValidator();
              break;
          case KING: 
        	  validator = new KingMoveValidator();
        	  break;
        }
        if (validator != null) {
            ValidationResult result = validator.validate(move, state);
            if (!result.isValid()) {
                return result;
            }
        }
        return new ValidationResult(false, "Move could not be validated.");
    }
}
