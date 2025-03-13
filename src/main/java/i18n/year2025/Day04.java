package i18n.year2025;

import i18n.util.Parser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class Day04 {
    
    private static final String FILENAME = "input/day04.txt";
    
    private static final Pattern PATTERN = Pattern
        .compile("\\w+:\\s+([\\w/-]+)\\s+(\\w{3} \\d{2}, \\d{4}, \\d{2}:\\d{2})");
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
        .ofPattern("MMM dd, yyyy, HH:mm");
    
    public static void main(String[] args) {
        final var lines = Parser.readAllLines(FILENAME);
        var sum = 0L;
        
        for (int i = 0; i < lines.size(); i += 3) {
            final var departureTime = parseZonedDateTime(lines.get(i));
            final var arrivalTime = parseZonedDateTime(lines.get(i + 1));
            
            sum +=  departureTime.until(arrivalTime, ChronoUnit.MINUTES);
        }
        
        System.out.println(sum);
    }
    
    private static ZonedDateTime parseZonedDateTime(String string) {
        final var matcher = PATTERN.matcher(string);
        
        if (matcher.find()) {
            final var zoneId = ZoneId.of(matcher.group(1));
            final var localDateTime = LocalDateTime
                .parse(matcher.group(2), DATE_TIME_FORMATTER);
            
            return ZonedDateTime.of(localDateTime, zoneId);
        } else {
            throw new IllegalArgumentException(
                "The string did not match the expected format: " + string
            );
        }
    }
}

