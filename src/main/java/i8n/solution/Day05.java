package i8n.solution;

import i8n.util.Parser;

import java.util.List;

public class Day05 {
    
    private static final String FILENAME = "input/day05.txt";
    private static final int PILE_OF_POO = Character.codePointOf("PILE OF POO");
    
    public static void main(String[] args) {
        final var lines = Parser.readAllLines(FILENAME);
        
        final var codePointList = lines
            .stream()
            .map(s -> s.codePoints().boxed().toList())
            .toList();
        
        final var maxLength = codePointList
            .stream()
            .mapToInt(List::size)
            .max()
            .orElseThrow();
        
        var count = 0;
        var column = 0;
        
        for (final var codePoints : codePointList) {
            if (column < codePoints.size() && codePoints.get(column).equals(PILE_OF_POO)) {
                count++;
            }
            column = ((column + 2) % maxLength);
        }
        
        System.out.println(count);
    }
}
