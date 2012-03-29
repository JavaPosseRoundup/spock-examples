package test.groovy

import main.groovy.domain.LightningTalk
import main.groovy.domain.Person
import spock.lang.Specification
import spock.lang.Shared

class DomainExampleWithSetupSpec extends Specification{
    @Shared def talks = []
    def setupSpec(){
        Person dj = new Person(lastName: "Hagberg",firstName: "D. J.")
        Person andrew = new Person(lastName: "Harmel-Law",firstName: "Andrew")
        Person chris = new Person(lastName: "Phelps",firstName: "Chris")
        talks << new LightningTalk(presenter: dj,topic: "Open Solaris")
        talks << new LightningTalk(presenter: dj,topic: "Call before you dig")
        talks << new LightningTalk(presenter: andrew,topic: "Pair Programming Tarot")
        talks << new LightningTalk(presenter: chris,topic: "Japanese B&Bs")
    }

    def "All talks accounted for"(){
        expect:
        talks.size() == 4
    }

    def "D.J. has two presentations"(){
        expect:
        talks.count {it.presenter.firstName == "D. J."} == 2
    }
}
