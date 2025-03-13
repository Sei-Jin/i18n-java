package i18n.year2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {
    
    private static final Day03 SOLUTION = new Day03();
    
    @Test
    void invalidTooShort() {
        final var input = "d9Ō";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void invalidTooLong() {
        final var input = "uwI.E9GvrnWļbzO";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void invalidNoUppercase() {
        final var input = "ž-2á";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void invalidNoLowercase() {
        final var input = "Ģ952W*F4";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void invalidNoOutside7BitAscii() {
        final var input = "?O6JQf";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void invalidNoDigit() {
        final var input = "xi~Rťfsa";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void valid1() {
        final var input = "r_j4XcHŔB";
        assertEquals(1, SOLUTION.solve(input));
    }
    
    @Test
    void valid2() {
        final var input = "71äĜ3";
        assertEquals(1, SOLUTION.solve(input));
    }
}