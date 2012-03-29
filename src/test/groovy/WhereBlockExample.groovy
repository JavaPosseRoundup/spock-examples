import spock.lang.Specification

class WhereBlockExample extends Specification {
    def "Where block with table of expected results"() {
        expect:
            name.size() == length

        where:
            // There are a couple of interesting things going on here. Below is a table of inputs. The column headers are a variable names that are created by spock
            // and are available in the expect block. The expect block is called with each "row" in the table. Tables can have any number of "columns"
            name      | length
            "Andrew"  | 6
            "D.J."    | 4
            "Chris"   | 5
            "Todd"    | 4
    }
}