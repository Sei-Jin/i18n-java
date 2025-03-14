package i18n.year2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {
    
    private static final Day06 SOLUTION = new Day06();
    
    @Test
    void solve() {
        final var input = """
            geléet
            träffs
            religiÃ«n
            tancées
            kÃ¼rst
            roekoeÃ«n
            skälen
            böige
            fÃ¤gnar
            dardÃ©es
            amènent
            orquestrÃ¡
            imputarão
            molières
            pugilarÃÂ£o
            azeitámos
            dagcrème
            zÃ¶ger
            ondulât
            blÃ¶kt
            
               ...d...
                ..e.....
                 .l...
              ....f.
            ......t..
            """;
        assertEquals(50, SOLUTION.solve(input));
    }
}