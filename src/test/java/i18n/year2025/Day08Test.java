package i18n.year2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Test {
    
    private static final Day08 SOLUTION = new Day08();
    
    @Test
    void tooShort() {
        final var input = "iS0";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void tooLong() {
        final var input = "V8AeC1S7KhP4Ļu";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void noVowel() {
        final var input = "pD9Ĉ*jXh";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void noConsonant() {
        final var input = "E1-0";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void noRecurringLetters() {
        final var input = "ĕnz2cymE";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void noDigit() {
        final var input = "tqd~üō";
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void validPasswords() {
        final var input = """
            IgwQúPtd9
            k2lp79ąqV
            """;
        assertEquals(2, SOLUTION.solve(input));
    }
}