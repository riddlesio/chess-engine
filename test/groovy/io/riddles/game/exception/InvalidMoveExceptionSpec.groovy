package io.riddles.game.exception

import spock.lang.Specification

class InvalidMoveExceptionSpec extends Specification {

    def "should prepend `Invalid move: ` to the passed message"() {

        given:
            def message = "Test"
            def exception = new InvalidMoveException(message)
        expect:
            exception.getMessage() == "Invalid move: " + message
    }
}

