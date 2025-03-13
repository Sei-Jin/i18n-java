package i18n.year2025;

import i18n.Solver;

import java.nio.charset.StandardCharsets;

public class Day01 implements Solver<Integer> {
    
    @Override
    public Integer solve(String input) {
        return input
            .lines()
            .mapToInt(line -> {
                final var bytes = line.getBytes(StandardCharsets.UTF_8).length;
                final var characters = line.length();
                
                final var validSMS = bytes <= 160;
                final var validTweet = characters <= 140;
                
                if (validSMS && validTweet) {
                    return 13;
                } else if (validSMS) {
                    return 11;
                } else if (validTweet) {
                    return 7;
                } else {
                    return 0;
                }
            })
            .sum();
    }
}