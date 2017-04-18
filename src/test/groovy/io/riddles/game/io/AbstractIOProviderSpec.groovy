package io.riddles.game.io

import spock.lang.Specification;

class AbstractIOProviderSpec extends Specification {

    class ConcreteIOProvider extends AbstractIOProvider {

        ConcreteIOProvider(IOHandler handler) {
            super(handler)
        }

        IOHandler publicGetHandler() {
            return this.getHandler()
        }
    }

    def "getHandler() should return the IOHandler passed to the constructor"() {

        given:
        def provider = new ConcreteIOProvider(handler)

        expect:
        provider.publicGetHandler() == handler

        where:
        handler << [Mock(IOHandler), null]
    }
}
