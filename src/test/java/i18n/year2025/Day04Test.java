package i18n.year2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day04Test {
    
    private static final Day04 SOLUTION = new Day04();
    
    @Test
    void testTrip1() {
        final var input = """
            Departure: Europe/London                  Mar 04, 2020, 10:00
            Arrival:   Europe/Paris                   Mar 04, 2020, 11:59
            """;
        assertEquals(59, SOLUTION.solve(input));
    }
    
    @Test
    void testTrip2() {
        final var input = """
            Departure: Europe/Paris                   Mar 05, 2020, 10:42
            Arrival:   Australia/Adelaide             Mar 06, 2020, 16:09
            """;
        assertEquals(1197, SOLUTION.solve(input));
    }
    
    @Test
    void testTrip3() {
        final var input = """
            Departure: Australia/Adelaide             Mar 06, 2020, 19:54
            Arrival:   America/Argentina/Buenos_Aires Mar 06, 2020, 19:10
            """;
        assertEquals(766, SOLUTION.solve(input));
    }
    
    @Test
    void testTrip4() {
        final var input = """
            Departure: America/Argentina/Buenos_Aires Mar 07, 2020, 06:06
            Arrival:   America/Toronto                Mar 07, 2020, 14:43
            """;
        assertEquals(637, SOLUTION.solve(input));
    }
    
    @Test
    void testTrip5() {
        final var input = """
            Departure: America/Toronto                Mar 08, 2020, 04:48
            Arrival:   Europe/London                  Mar 08, 2020, 16:52
            """;
        assertEquals(484, SOLUTION.solve(input));
    }
    
    @Test
    void testTrips1to5() {
        final var input = """
            Departure: Europe/London                  Mar 04, 2020, 10:00
            Arrival:   Europe/Paris                   Mar 04, 2020, 11:59
            
            Departure: Europe/Paris                   Mar 05, 2020, 10:42
            Arrival:   Australia/Adelaide             Mar 06, 2020, 16:09
            
            Departure: Australia/Adelaide             Mar 06, 2020, 19:54
            Arrival:   America/Argentina/Buenos_Aires Mar 06, 2020, 19:10
            
            Departure: America/Argentina/Buenos_Aires Mar 07, 2020, 06:06
            Arrival:   America/Toronto                Mar 07, 2020, 14:43
            
            Departure: America/Toronto                Mar 08, 2020, 04:48
            Arrival:   Europe/London                  Mar 08, 2020, 16:52
            """;
        assertEquals(3143, SOLUTION.solve(input));
    }
}