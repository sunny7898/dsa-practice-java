package recursion;

public class SudokuSolver {
    boolean isValid(char[][] board, char ch, int row, int col) {
        for (int i = 0; i < 9; i++) {

            // checking in column
            if (board[i][col] == ch) return false;

            // checking in row
            if (board[row][i] == ch) return false;

            // checking in the 3 x 3 block of cell
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) return false;
        }
        return true;
    }

    boolean solve(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isValid(board, ch, row, col)) {
                            board[row][col] = ch;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    // we couldn't place anything
                    return false;
                }
            }
        }
        // all are filled
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
