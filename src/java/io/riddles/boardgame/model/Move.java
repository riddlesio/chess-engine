package io.riddles.boardgame.model;

import io.riddles.chess.model.ChessPieceType;

/**
 * @author Niko van Meurs <niko@riddles.io>
 */
public final class Move {

	
	public enum MoveTypes{
		Castling, Promotion, Regular
	}
	
	
	public MoveTypes moveType;
	
    /**
     * boolean which indicates if the castling is on the king side
     */	
	private boolean kingCastle;
	
    /**
     * PieceType which the pawn will promote into
     */	
	private ChessPieceType promotionPiece;
	
			
    /**
     * Coordinate of the Field from which should be moved
     */
    private Coordinate from;

    /**
     * Coordinate of the Field to which a Piece should be moved
     */
    private Coordinate to;

 
    
    /**
     * Returns if the castling is a king castle
     * @return boolean
     */
    public ChessPieceType getPromotionType() {
        return promotionPiece;
    } 
        
    
    /**
     * Returns if the castling is a king castle
     * @return boolean
     */
    public boolean isKingCastle() {
        return kingCastle;
    } 
    
    
    /**
     *
     * @param kingCastle indicates if the castling is on the king side
     */
    public Move(boolean kingCastle) {

        this.kingCastle = kingCastle;
        this.moveType = MoveTypes.Castling;
    }    
    
    /**
     *
     * @param from Points to the field from which the move is executed
     * @param to   Points to the field to which the move is executed
     */
    public Move(Coordinate from, Coordinate to, ChessPieceType promotionPiece) {

        this.from = from;
        this.to = to;
        this.promotionPiece = promotionPiece;
        this.moveType = MoveTypes.Promotion;
    }

    
    
    /**
     *
     * @param from Points to the field from which the move is executed
     * @param to   Points to the field to which the move is executed
     */
    public Move(Coordinate from, Coordinate to) {

        this.from = from;
        this.to = to;
        this.moveType = MoveTypes.Regular;
    }
    
    
    
    /**
     * Returns the coordinate for the move's source Field
     * @return Coordinate
     */
    public Coordinate getFrom() {
        return from;
    }

    /**
     * Returns the coordinate for the move's target Field
     * @return Coordinate
     */
    public Coordinate getTo() {
        return to;
    }
}
