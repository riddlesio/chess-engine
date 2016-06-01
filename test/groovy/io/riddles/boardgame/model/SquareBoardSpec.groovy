package io.riddles.boardgame.model

import spock.lang.Specification

class SquareBoardSpec extends Specification {

    def "size() should return the square root of the amount of fields passed to SquareBoard"() {

        given:
            def fields = (1..count).collect { _ -> new Field() } as ArrayList<Field>
            def board = new SquareBoard(fields)

        expect:
        board.size() == result

        where:
        count | result
        4     | 2
        9     | 3
        16    | 4
        25    | 5
    }
}
