package i18n.year2025;

import i18n.Solver;

import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class Day03 implements Solver<Integer> {
    
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 12;
    private static final CharsetEncoder ASCII_ENCODER = StandardCharsets.US_ASCII.newEncoder();
    
    @Override
    public Integer solve(String input) {
        return (int) input
            .lines()
            .filter(s -> s.length() >= MIN_LENGTH && s.length() <= MAX_LENGTH)
            .filter(p -> p.chars().anyMatch(Character::isDigit))
            .filter(p -> p.chars().anyMatch(Character::isUpperCase))
            .filter(p -> p.chars().anyMatch(Character::isLowerCase))
            .filter(p -> p.chars().anyMatch(i -> !ASCII_ENCODER.canEncode((char) i)))
            .count();
    }
}
