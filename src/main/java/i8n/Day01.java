package i8n;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day01 {
    
    private static final String filename = "input/day01.txt";
    
    public static void main(String[] args) {
        final var lines = readInput();
        final var totalCost = calculateTotalCost(lines);
        System.out.println(totalCost);
    }
    
    private static List<String> readInput() {
        try {
            return Files.readAllLines(Path.of(filename), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static int calculateTotalCost(List<String> lines) {
        var totalCost = 0;
        
        for (final var line : lines) {
            var cost = 0;
            
            final var bytes = line.getBytes(StandardCharsets.UTF_8).length;
            final var characters = line.length();
            
            if (bytes <= 160 && characters <= 140) {
                cost += 13;
            } else if (bytes <= 160) {
                cost += 11;
            } else if (characters <= 140) {
                cost += 7;
            }
            
            totalCost += cost;
        }
        
        return totalCost;
    }
}