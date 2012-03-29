package test.groovy

import spock.lang.Specification
import spock.lang.Shared
import main.groovy.domain.LightningTalk
import main.groovy.domain.Person

class SimpleDomainExample extends Specification{

    // Variables tagged with the @Shared annotation are constructed once and available to all tests. Typically used for creating expensive resources
    @Shared talk = new LightningTalk(presenter: new Person(firstName: "Todd",lastName: "Costella"),topic: "Building a hackintosh")

    def "One lightning talk"(){
        expect:
            talk.topic =~ /Building*/
            talk.presenter.firstName == "Todd"
    }

    def "One lightning talk last name test"(){
        expect:
            talk.presenter.lastName == "Costella"
    }



}
