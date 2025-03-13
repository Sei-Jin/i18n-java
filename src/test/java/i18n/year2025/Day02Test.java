package i18n.year2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {
    
    private static final Day02 SOLUTION = new Day02();
    
    @Test
    void solve() {
        final var input = """
            2019-06-05T08:15:00-04:00
            2019-06-05T14:15:00+02:00
            2019-06-05T17:45:00+05:30
            2019-06-05T05:15:00-07:00
            2011-02-01T09:15:00-03:00
            2011-02-01T09:15:00-05:00
            """;
        assertEquals("2019-06-05T12:15:00+00:00", SOLUTION.solve(input));
    }
}