package i18n.year2025;

import i18n.Solver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

public class Day09 implements Solver<String> {
    
    private static final LocalDate NINE_ELEVEN = LocalDate.parse("2001-09-11");
    
    @Override
    public String solve(String input) {
        final var formatters = getDateTimeFormatters();
        
        final var nameDateStrings = new HashMap<String, List<String>>();
        
        for (final var line : input.lines().toList()) {
            final var parts = line.split(": ");
            
            final var dateInput = parts[0];
            final var namesInput = parts[1];
            
            final var names = Arrays.stream(namesInput.split(", ")).toList();
            
            for (final var name : names) {
                final var list = nameDateStrings.getOrDefault(name, new ArrayList<>());
                list.add(dateInput);
                nameDateStrings.put(name, list);
            }
        }
        
        final var nameDates = new HashMap<String, List<LocalDate>>();
        
        for (final var entry : nameDateStrings.entrySet()) {
            for (final var formatter : formatters) {
                final var dates = parseDates(entry.getValue(), formatter);
                
                if (!dates.isEmpty()) {
                    nameDates.put(entry.getKey(), dates);
                    break;
                }
            }
        }
        
        final var valid = nameDates
            .entrySet()
            .stream()
            .filter(entry ->
                entry
                    .getValue()
                    .stream()
                    .anyMatch(date -> date.equals(NINE_ELEVEN))
            )
            .map(Map.Entry::getKey)
            .sorted()
            .toList();
        
        return String.join(" ", valid);
    }
    
    private static ArrayList<DateTimeFormatter> getDateTimeFormatters() {
        return new ArrayList<>(Arrays.asList(
            new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-uu")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT),
            new DateTimeFormatterBuilder()
                .appendPattern("MM-dd-uu")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT),
            
            new DateTimeFormatterBuilder()
                .appendPattern("uu-MM-dd")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT),
            
            new DateTimeFormatterBuilder()
                .appendPattern("uu-dd-MM")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT)
        ));
    }
    
    private List<LocalDate> parseDates(List<String> dates, DateTimeFormatter formatter) {
        try {
            return dates
                .stream()
                .map(date -> LocalDate.parse(date, formatter))
                .toList();
        } catch (DateTimeParseException e) {
            return new ArrayList<>();
        }
    }
}
