package examples;

public class NQueens {
    public static boolean[][] calculate(
            int n) throws Exception {
        boolean[][] board    = new boolean[n][n];
        if(solve(board, n, 0)){
            return board;
        } else {
            throw new Exception(
                    "Cannot find any solution!"
            );
        }
    }

    private static boolean solve(
            boolean[][] board,
            int         n,
            int         row
    ) {
        if(row >= n)
            return true;

        for(int col = 0; col < n; ++col) {
            if(isValid(board, n, row, col)) {
                board[row][col] = true;
                if(solve(board, n, row + 1)){
                    return true;
                }
            }
            board[row][col] = false;
        }
        return false;
    }

    private static boolean isValid(
            boolean[][] board,
            int n,
            int row,
            int col
    ) {
        return
                !inCol(board, n, col) &&
                !inRow(board, n, row) &&
                !inMainDiagonal(board, n, row, col) &&
                !inSubDiagonal(board, n, row, col);
    }

    private static boolean inMainDiagonal(
            boolean[][] board,
            int n,
            int row,
            int col
    ) {
        int row_bound =
                row - col >= 0
                        ? row - col
                        : 0;
        int col_bound =
                row - col >= 0
                        ? 0
                        : col - row;
        for(int r = row_bound, c = col_bound; c < n - row_bound && r < n - col_bound; ++c, ++r) {
            if(board[r][c]){
                return true;
            }
        }
        return false;
    }

    private static boolean inSubDiagonal(
            boolean[][] board,
            int n,
            int row,
            int col
    ) {
        int min_bound =
                row + col > n - 1
                        ? (row + col) % (n - 1)
                        : 0;
        int max_bound =
                row + col > n - 1
                        ? n - 1
                        : row + col;
        for(int r = max_bound, c = min_bound; r >= min_bound && c <= max_bound; ++c, --r) {
            if(board[r][c]){
                return true;
            }
        }
        return false;
    }

    private static boolean inRow(
            boolean[][] board,
            int n,
            int row
    ) {
        for(int index = 0; index < n; ++index){
            if(board[row][index])
                return true;
        }
        return false;
    }

    private static boolean inCol(
            boolean[][] board,
            int n,
            int col
    ) {
        for(int index = 0; index < n; ++index){
            if(board[index][col])
                return true;
        }
        return false;
    }

    public static void show(
            boolean[][] board,
            int         n) {
        for(int row = 0; row < n; ++row) {
            for(int col = 0; col < n; ++col) {
                System.out.print(((board[row][col]) ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}
