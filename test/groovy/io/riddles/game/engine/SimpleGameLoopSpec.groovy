package io.riddles.game.engine

import io.riddles.game.io.IOProvider
import io.riddles.game.io.IORequest
import io.riddles.game.io.IOResponse
import spock.lang.Specification

class SimpleGameLoopSpec extends Specification {

    class State {
        int count
        int exceptions

        State(State previousState, Exception exception) {
            count = previousState.getCount() + 1
            exceptions = previousState.getExceptions() + 1
        }

        State(State previousState) {
            count = previousState.getCount() + 1
            exceptions = previousState.getExceptions()
        }

        State() {
            count = 0
            exceptions = 0
        }

        int getCount() {
            return count
        }

        int getExceptions() {
            return exceptions
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

    def "run() should loop until the game is finished and return the final state"() {

        given:
        def loop = new SimpleGameLoop<State>()
        def initialState = new State()

        def processor = Mock(Processor)
        processor.processInput(_, _) >> { State s, IOResponse r -> new State(s) }

        def ioProvider = Mock(IOProvider)
        ioProvider.execute(_ as IORequest) >> Mock(IOResponse)

        when:
        def finalState = loop.run(ioProvider, processor, initialState)

        then:
        cycles * processor.hasGameEnded(_) >> false
        1 * processor.hasGameEnded(_) >> true

        expect:
        finalState != null
        finalState.getCount() == initialState.getCount() + cycles
        finalState.getExceptions() == 0

        where:
        cycles << (1..5)
    }

    def "run() should call processor.processException the IOProvider.execute throws an exception"() {

        given:
        def loop = new SimpleGameLoop<State>()
        def initialState = new State()

        def processor = Mock(Processor)
        processor.processInput(_, _) >> { State s, IOResponse r -> new State(s) }
        processor.processException(_ as State, _ as Exception) >> { State s, Exception e -> new State(s, e) }

        def ioProvider = Mock(IOProvider)
        ioProvider.execute(_) >> { throw new IOException("Timeout (2000ms)") }

        when:
        def finalState = loop.run(ioProvider, processor, initialState)

        then:
        cycles * processor.hasGameEnded(_) >> false
        1 * processor.hasGameEnded(_) >> true

        expect:
        finalState != null
        finalState.getExceptions() == cycles
        finalState.getCount() == initialState.getCount() + cycles

        where:
        cycles << (1..5)
    }

    def "run() should call processor.processException when Processor.processInput throws an exception"() {

        given:
        def loop = new SimpleGameLoop<State>()
        def initialState = new State()

        def processor = Mock(Processor)
        processor.processInput(_ as State, _ as IOResponse) >> { throw new Exception("Error") }
        processor.processException(_ as State, _ as Exception) >> { State s, Exception e -> new State(s, e) }

        def ioProvider = Mock(IOProvider)
        ioProvider.execute(_) >> Mock(IOResponse)

        when:
        def finalState = loop.run(ioProvider, processor, initialState)

        then:
        cycles * processor.hasGameEnded(_) >> false
        1 * processor.hasGameEnded(_) >> true

        expect:
        finalState != null
        finalState.getExceptions() == cycles
        finalState.getCount() == initialState.getCount() + cycles

        where:
        cycles << (1..5)
    }
}
