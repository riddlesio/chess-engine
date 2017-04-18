package io.riddles.game.exception

import spock.lang.Specification

class InvalidInputExceptionSpec extends Specification {

    def "should prepend `Invalid input: ` to the passed message"() {

        given:
            def message = "Test"
            def exception = new InvalidInputException(message)
        expect:
            exception.getMessage() == "Invalid input: " + message
    }
}
