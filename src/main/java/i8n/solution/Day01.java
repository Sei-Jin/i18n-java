package i8n.solution;

import i8n.util.Parser;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Day01 {
    
    private static final String FILENAME = "input/day01.txt";
    
    public static void main(String[] args) {
        final var lines = Parser.readAllLines(FILENAME);
        final var totalCost = calculateTotalCost(lines);
        System.out.println(totalCost);
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