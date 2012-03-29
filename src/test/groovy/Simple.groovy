package test.groovy

import spock.lang.Specification

class Simple extends Specification {


    // Scoping. Variables defined in when block available in then
    def "Very Simple Specification"() {
        when:
           def foo = 1
        then:
           foo == 1
    }

    // Specs can use multiple blocks to improve readability
    def "Spec with multiple blocks"(){
        when:
         def foo = 1
        and:
          def bar = 2
        then:
          foo == 1
          bar == 2
    }

    // Blocks can have descriptions
    def "Spec with labeled blocks"(){
        when: "An initial value of foo and bar"
            def foo = 1
            def bar = 2
        then: "foo should be 1 and bar should be 2"
            foo == 1
            bar == 2
    }

    // setup and expect are synonyms for when and then.
    def "Spec with setup and expects blocks"(){
        setup:
            def foo = 1
            def bar = 2
        expect:
            foo == 1
            bar == 2
    }


}
