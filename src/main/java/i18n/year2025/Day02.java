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
        
        final var entryCounts = countEntries(normalizedTimes);
        
        final var appearsFourOrMoreTimes = entryCounts
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() >= 4)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElseThrow(() -> new AssertionError(
                "No entries had a value of 4 or more.")
            );
        
        return formatOutput(appearsFourOrMoreTimes);
    }
    
    private static <T> Map<T, Integer> countEntries(List<T> list) {
        final var entryCounts = new HashMap<T, Integer>();
        
        for (final var entry : list) {
            final var count = entryCounts.getOrDefault(entry, 0) + 1;
            entryCounts.put(entry, count);
        }
        
        return entryCounts;
    }
    
    private static String formatOutput(ZonedDateTime appearsFourOrMoreTimes) {
        var output = appearsFourOrMoreTimes.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        
        if (appearsFourOrMoreTimes.getZone() == ZoneOffset.UTC) {
            output = output.substring(0, output.length() - 1) + "+00:00";
        }
        
        return output;
    }
}
