package i18n.year2025;

import i18n.Solver;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day02 implements Solver<String> {
    
    @Override
    public String solve(String input) {
        final var normalizedTimes = input
            .lines()
            .map(ZonedDateTime::parse)
            .map(time -> time.withZoneSameInstant(ZoneOffset.UTC))
            .toList();
        
        final var timeCounts = countEntries(normalizedTimes);
        
        final var time = timeCounts
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() >= 4)
            .findFirst()
            .map(Map.Entry::getKey)
            .orElseThrow(() -> new AssertionError(
                "No entries had a value of 4 or more.")
            );
        
        return time.format(DateTimeFormatter.ofPattern("y-MM-dd'T'H:m:ssxxx"));
    }
    
    private static <T> Map<T, Integer> countEntries(List<T> list) {
        final var entryCounts = new HashMap<T, Integer>();
        
        for (final var entry : list) {
            final var count = entryCounts.getOrDefault(entry, 0) + 1;
            entryCounts.put(entry, count);
        }
        
        return entryCounts;
    }
}
