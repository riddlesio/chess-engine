package io.riddles.boardgame.logic

import io.riddles.chess.data.Piece
import spock.lang.Specification

class PieceLogicSpec extends Specification {

    enum PieceColor { BLACK, WHITE }
    enum PieceType { A, B }

    class ConcretePiece extends Piece<PieceType, PieceColor> {

        ConcretePiece(PieceType pieceType, PieceColor pieceColor) {
            super(pieceType, pieceColor)
        }
    }

    def "hasColor should return True if the given Piece has the specified PieceColor, False otherwise"() {

        given:
        def logic = new PieceLogic<PieceType, PieceColor>()

        expect:
        logic.hasColor(color, piece) == result

        where:
        color            | piece                                            | result
        PieceColor.WHITE | new ConcretePiece(PieceType.A, PieceColor.BLACK) | false
        PieceColor.BLACK | new ConcretePiece(PieceType.B, PieceColor.BLACK) | true
        PieceColor.WHITE | new ConcretePiece(PieceType.B, PieceColor.WHITE) | true
        PieceColor.BLACK | new ConcretePiece(PieceType.A, PieceColor.WHITE) | false
    }

    def "hasType should return True if the given Piece has the specified PieceType, False otherwise"() {

        given:
        def logic = new PieceLogic<PieceType, PieceColor>()

        expect:
        logic.hasType(type, piece) == result

        where:
        type        | piece                                            | result
        PieceType.A | new ConcretePiece(PieceType.A, PieceColor.BLACK) | true
        PieceType.B | new ConcretePiece(PieceType.B, PieceColor.BLACK) | true
        PieceType.A | new ConcretePiece(PieceType.B, PieceColor.WHITE) | false
        PieceType.B | new ConcretePiece(PieceType.A, PieceColor.WHITE) | false
    }
}
