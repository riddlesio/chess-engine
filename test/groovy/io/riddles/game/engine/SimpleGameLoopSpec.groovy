package io.riddles.game.engine

import io.riddles.game.io.IOProvider
import spock.lang.Specification

class SimpleGameLoopSpec extends Specification {

    class State {
        int count

        State(State previousState) {
            count = previousState.getCount() + 1
        }

        State() {
            count = 0
        }

        int getCount() {
            return count
        }
    }

    def "run() should return the first state if the game is immediately finished"() {

        given:
            def ioProvider = Mock(IOProvider)
            def initialState = new State()
            def processor = Mock(Processor)


            def loop = new SimpleGameLoop<State>()

        when:
            def finalState = loop.run(ioProvider, processor, initialState)

        then:
        1 * processor.hasGameEnded(_) >> true

        expect:
            finalState.getCount() == initialState.getCount()


    }
}
