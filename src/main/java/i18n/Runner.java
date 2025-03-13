package i18n;

public class Runner {
    
    public static void main(String[] args) {
        final var output = run(2025,1);
        System.out.println(output);
    }
    
    private static String run(int year, int day) {
        final var solution = new Solution(year, day);
        final var input = solution.retrieveInput();
        final var solver = solution.determineSolver();
        return solver.solve(input).toString();
    }
}
