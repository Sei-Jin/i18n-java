package i18n.year2025;

import i18n.Solver;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;
import java.util.stream.Gatherers;

public class Day04 implements Solver<Integer> {
    
    private static final Pattern PATTERN = Pattern
        .compile("\\w+:\\s+([\\w/-]+)\\s+(\\w{3} \\d{2}, \\d{4}, \\d{2}:\\d{2})");
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
        .ofPattern("MMM dd, yyyy, HH:mm");
    
    @Override
    public Integer solve(String input) {
        return input
            .lines()
            .gather(Gatherers.windowFixed(3))
            .mapToInt(window -> {
                final var departure = parseTime(window.get(0));
                final var arrival = parseTime(window.get(1));
                return (int) departure.until(arrival, ChronoUnit.MINUTES);
            })
            .sum();
    }
    
    private static ZonedDateTime parseTime(String string) {
        final var matcher = PATTERN.matcher(string);
        
        if (matcher.find()) {
            final var zoneId = ZoneId.of(matcher.group(1));
            final var time = LocalDateTime
                .parse(matcher.group(2), DATE_TIME_FORMATTER);
            
            return ZonedDateTime.of(time, zoneId);
        } else {
            throw new IllegalArgumentException(
                "The string did not match the expected format: " + string
            );
        }
    }
}

