import java.util.Arrays;

public class SolveNQueensSolution {
//    public List<List<String>> solveNQueens(int n) {
//
//    }
//
//    public List<String> initBoard(int n) {
//        String[] col = new String[n];
//        Arrays.fill(col, ".");
//        Arrays.toString(col);
//    }

    public static void main(String[] args) {
        String[] list = new String[10];
        Arrays.fill(list, ".");
        String col = String.join("", list);
        String[] row = new String[10];
        Arrays.fill(row, col);
        System.out.println(Arrays.toString(row));
    }
}
