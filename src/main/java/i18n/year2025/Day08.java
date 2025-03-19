package i18n.year2025;

import i18n.Solver;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Day08 implements Solver<Integer> {
    
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 12;
    private static final Pattern VOWELS = Pattern.compile("[aeiou]");
    private static final Pattern CONSONANTS = Pattern.compile("[bcdfghjklmnpqrstvwxyz]");
    
    @Override
    public Integer solve(String input) {
        return (int) input
            .lines()
            .map(Day08::normalize)
            .filter(s -> s.length() >= MIN_LENGTH && s.length() <= MAX_LENGTH)
            .filter(s -> s.chars().anyMatch(Character::isDigit))
            .filter(s -> VOWELS.matcher(s).find())
            .filter(s -> CONSONANTS.matcher(s).find())
            .filter(Day08::hasAllUniqueCharacters)
            .count();
    }
    
    private static String normalize(String s) {
        return Normalizer
            .normalize(s, Normalizer.Form.NFKD)
            .replaceAll("\\p{M}", "")
            .toLowerCase();
    }
    
    private static boolean hasAllUniqueCharacters(String s) {
        final var set = new HashSet<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        
        return set.size() == s.length();
    }
}
