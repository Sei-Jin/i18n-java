package i18n.year2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
    
    private static final Day05 SOLUTION = new Day05();
    
    @Test
    void solve() {
        final var input = """
             ⚘   ⚘\s
              ⸫   ⸫
            🌲   💩 \s
                 ⸫⸫
             🐇    💩
            ⸫    ⸫\s
            ⚘🌲 ⸫  🌲
            ⸫    🐕\s
              ⚘  ⸫\s
            ⚘⸫⸫   ⸫
              ⚘⸫  \s
             💩  ⸫ \s
                 ⸫⸫
            """;
        assertEquals(2, SOLUTION.solve(input));
    }
}