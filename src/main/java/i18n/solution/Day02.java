package i18n.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day02 {
    
    private static final String filename = "input/day02.txt";
    
    public static void main(String[] args) {
        final var times = readInput();
        
        final var normalizedTimes = times
            .stream()
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
        
        final var output = formatOutput(appearsFourOrMoreTimes);
        System.out.println(output);
    }
    
    private static List<ZonedDateTime> readInput() {
        try (final var reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines()
                .map(ZonedDateTime::parse)
                .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
