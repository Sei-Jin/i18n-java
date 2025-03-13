package i18n.year2025;

import i18n.Solver;

import java.util.List;
import java.util.stream.IntStream;

public class Day05 implements Solver<Integer> {
    
    private static final int PILE_OF_POO = Character.codePointOf("PILE OF POO");
    
    @Override
    public Integer solve(String input) {
        final var codePointLists = input
            .lines()
            .map(s -> s.codePoints().boxed().toList())
            .toList();
        
        final var maxLength = codePointLists
            .stream()
            .mapToInt(List::size)
            .max()
            .orElseThrow();
        
        return (int) IntStream
            .range(0, codePointLists.size())
            .mapToObj(i -> new Point(i, ((i * 2) % maxLength)))
            .filter(p -> p.column() < codePointLists.get(p.row()).size())
            .filter(p -> codePointLists.get(p.row()).get(p.column()).equals(PILE_OF_POO))
            .count();
    }
    
    private record Point(int row, int column) {}
}
