import examples.NQueens;

public class App {
    public static void main(String[] args) throws Exception {
        boolean[][] board = NQueens.calculate(4);
        NQueens.show(board, 4);
    }
}
