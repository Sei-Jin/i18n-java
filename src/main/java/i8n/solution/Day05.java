package i8n.solution;

import i8n.util.Parser;

import java.util.List;
import java.util.stream.IntStream;

public class Day05 {
    
    private static final String FILENAME = "input/day05.txt";
    private static final int PILE_OF_POO = Character.codePointOf("PILE OF POO");
    
    public static void main(String[] args) {
        final var lines = Parser.readAllLines(FILENAME);
        
        final var codePointLists = lines
            .stream()
            .map(s -> s.codePoints().boxed().toList())
            .toList();
        
        final var maxLength = codePointLists
            .stream()
            .mapToInt(List::size)
            .max()
            .orElseThrow();
        
        final var count = IntStream
            .range(0, codePointLists.size())
            .mapToObj(i -> new Point(i, ((i * 2) % maxLength)))
            .filter(p -> p.column() < codePointLists.get(p.row()).size())
            .filter(p -> codePointLists.get(p.row()).get(p.column()).equals(PILE_OF_POO))
            .count();
        
        System.out.println(count);
    }
    
    private record Point(int row, int column) {}
}
