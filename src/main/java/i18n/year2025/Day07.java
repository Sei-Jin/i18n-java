package i18n.year2025;

import i18n.Solver;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Day07 implements Solver<Integer> {
    
    private static final Pattern INPUT_LINE = Pattern.compile(
        "(.+)\\s+(\\d+)\\s+(\\d+)"
    );
    
    @Override
    public Integer solve(String input) {
        final var inputTimes = input
            .lines()
            .map(line -> {
                final var matcher = INPUT_LINE.matcher(line);
                
                if (matcher.find()) {
                    final var dateTimeInput = matcher.group(1);
                    final var correctMinutesInput = matcher.group(2);
                    final var incorrectMinutesInput = matcher.group(3);
                    
                    final var dateTime = ZonedDateTime.parse(
                        dateTimeInput,
                        DateTimeFormatter.ISO_OFFSET_DATE_TIME
                    );
                    final var correctMinutes = Integer.parseInt(correctMinutesInput);
                    final var incorrectMinutes = Integer.parseInt(incorrectMinutesInput);
                    
                    return new Input(dateTime, correctMinutes, incorrectMinutes);
                } else {
                    throw new IllegalArgumentException(
                        "Input did not match the expect format" + line
                    );
                }
            })
            .toList();
        
        final var halifax = ZoneId.of("America/Halifax");
        final var santiago = ZoneId.of("America/Santiago");
        
        final var correctedTimes = inputTimes
            .stream()
            .map(line -> {
                final var dateTime = line.dateTime();
                
                final var isHalifax = dateTime
                    .withZoneSameInstant(halifax)
                    .getOffset()
                    .equals(dateTime.getOffset());

                final var normalizedZone = isHalifax ? halifax : santiago;
                
                return dateTime
                    .minusMinutes(line.incorrectMinutes())
                    .plusMinutes(line.correctMinutes())
                    .withZoneSameInstant(normalizedZone)
                    .toOffsetDateTime();
            })
            .toList();
        
        return IntStream
            .range(0, correctedTimes.size())
            .map(i -> {
                final var time = correctedTimes.get(i);
                final var lineNumber = i + 1;
                return time.getHour() * lineNumber;
            })
            .sum();
    }
    
    private record Input(ZonedDateTime dateTime, int correctMinutes, int incorrectMinutes) {}
}
