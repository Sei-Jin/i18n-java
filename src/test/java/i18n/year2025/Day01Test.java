package i18n.year2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    
    private static final Day01 SOLUTION = new Day01();
    
    @Test
    void notValid() {
        final var input = """
            néztek bele az „ártatlan lapocskába“, mint ahogy belenézetlen mondták ki rá a halálos itéletet a sajtó csupa 20–30 éves birái s egyben hóhérai.
            """;
        assertEquals(0, SOLUTION.solve(input));
    }
    
    @Test
    void validSmsAndTweet() {
        final var input = """
            livres, et la Columbiad Rodman ne dépense que cent soixante livres de poudre pour envoyer à six milles son boulet d'une demi-tonne.  Ces
            """;
        assertEquals(13, SOLUTION.solve(input));
    }
    
    @Test
    void validTweet() {
        final var input = """
            Люди должны были тамъ и сямъ жить въ палаткахъ, да и мы не были помѣщены въ посольскомъ дворѣ, который также сгорѣлъ, а въ двухъ деревянныхъ
            """;
        assertEquals(7, SOLUTION.solve(input));
    }
    
    @Test
    void validSMS() {
        final var input = """
            Han hade icke träffat Märta sedan Arvidsons middag, och det hade gått nära en vecka sedan dess. Han hade dagligen promenerat på de gator, där
            """;
        assertEquals(11, SOLUTION.solve(input));
    }
}