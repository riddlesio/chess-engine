package io.riddles.chess.game.processor;

import io.riddles.chess.data.ChessBoard;
import io.riddles.chess.game.state.ChessPlayerState;
import io.riddles.chess.game.state.ChessState;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ValidationResult;
import io.riddles.chess.move.ChessMove;
import io.riddles.chess.validator.ChessMoveValidator;

/**
 * Created by joost on 4/21/17.
 */
public class ChessLogic {
    /**
     * Takes a BlockBattleState and applies the move(s).
     * Returns nothing, but transforms the given BlockBattleState.
     */
    public static void executeMove(ChessState state, ChessPlayerState playerState) {
        ChessBoard board = state.getBoard();
        int playerId = playerState.getPlayerId();

        ChessMove move = playerState.getMove();
        ChessMoveValidator validator = new ChessMoveValidator();
        ValidationResult vr = validator.validate(move, state);
        if (vr.isValid()) {
            board.move(move.getFrom(), move.getTo());
        }
        System.out.println("Move " + board.getFieldAt(move.getFrom()) + " to " + move.getTo().getX() + "," + move.getTo().getY() + ": " + vr.isValid() + " "+ vr.getReason());


    }

    public ChessPieceColor getPlayerColor(int playerId) {
        return (playerId == 0) ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
    }
}
