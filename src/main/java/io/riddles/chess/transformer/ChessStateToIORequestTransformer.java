package io.riddles.chess.transformer;

/**
 * Transforms a ChessState into an IORequest
 */
public class ChessStateToIORequestTransformer {


    public ChessStateToIORequestTransformer() {
    }

    /**
     * @inheritDoc
     */

    /**
     * Checks whether the passed state holds pawn which can be promoted
     * @param state The state which to check for a promotable piece
     * @return True if the states contains a promotable pawn, false otherwise
     */
    /*
    protected boolean stateHasPromotablePiece(ChessState state) {

        ChessBoard board = state.getBoard();
        ChessMove previousMove = getLastMove(state);

        Point coordinate = previousMove.getTo();
        ChessPiece movedPiece = getMovedPiece(state);

        if (!movedPiece.hasType(ChessPieceType.PAWN))) {
            return false;
        }

        if (movedPiece.hasColor(ChessPieceColor.WHITE)) {
            return boardLogic.isCoordinateAtBottomEdge(board, coordinate);
        }

        return boardLogic.isCoordinateAtTopEdge(board, coordinate);
    }
    */


    /**
     * Get the piece which was moved in the previous IOResponse
     * @param state The state from which to retrieve the last moved piece
     * @return The last moved piece
     */
    /*
    protected ChessPiece getMovedPiece(ChessState state) {

        ChessMove move = getLastMove(state);
        Point coordinate = move.getTo();

        ChessPiece piece = state
                .getBoard()
                .getFieldAt(coordinate);

        if(piece == null) {
            throw new RuntimeException("No piece present at target coordinate");
        }

        return piece ;
    }
    */

    /**
     * Gets the last executed move
     * @param state The state from which to retrieve the last move
     * @return The last executed move
     */
    /*
    protected ChessMove getLastMove(ChessState state) {

        Optional<ChessMove> optionalPreviousMove = state.getMove();

        if(!optionalPreviousMove.isPresent()) {
            throw new RuntimeException("No move present in given state");
        }

        return optionalPreviousMove.get();
    }
    */
}
