package test.groovy

import spock.lang.Specification

class SimpleNFRSpecExample extends Specification {

    Object AVERAGE_LOAD = null // This _should_ be a singleton which runs up an average load (with grinder?)
    Object NORMAL_OPERATING_CONDITIONS = null // this _should_ be a singleton which sets up an environment described as "normal operating conditions" (with puppet / chef?)

    def "Under AVERAGE_LOAD and NORMAL_OPERATING_CONDITIONS 80% of FIXTURE_SEARCH_REQUESTS should return within one second"() {

        given:
            AVERAGE_LOAD
        and:
            NORMAL_OPERATING_CONDITIONS
        when:
            def results = 5.times (mySearchController.searchForFixtures("My fixture search string"))
        then:
//            in.results.every.title.equals("Search Result") - WHAT I WOULD LIKE THIS TO READ LIKE
            results.count { result -> result.title.equals("Search Result") } == results.size
//            80.percent.of.results.responseTime <= 1.secs  - WHAT I WOULD LIKE THIS TO READ LIKE
            results.count { result -> result.responseTime <= 1000 } >= results.size * 0.8
    }

}
