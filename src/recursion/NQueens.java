package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /*
    // Brute force:
    boolean checkIfSafeToPlace(ArrayList<String> board, int n, int row, int col) {

        int originalRow = row;
        int originalCol = col;

        // checking backward horizontally
        while (col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        // checking backward upper diagonal
        col = originalCol;
        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        // checking backward lower diagonal
        row = originalRow;
        col = originalCol;
        while (row < n && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }

        // all good
        return true;
    }

    List<List<String>> getAllPlacements(ArrayList<String> board, int n, int currCol) {
        List<List<String>> res = new ArrayList<>();

        if (currCol == n) {
            res.add(new ArrayList<>(board));
            return res;
        }

        for (int row = 0; row < n; row++){
            if (checkIfSafeToPlace(board, n, row, currCol)) {
                String original = board.get(row);
                String modified = original.substring(0, currCol) + 'Q' + original.substring(currCol + 1);
                board.set(row, modified);
                res.addAll(getAllPlacements(board, n, currCol + 1));
                board.set(row, original);
            }
        }
        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> board = new ArrayList<>();

        char[] row = new char[n];
        // Creating the row
        Arrays.fill(row, '.');

        // Creating the board
        for(int i = 0; i < n; i++) board.add(new String(row));


        int startColumn = 0;
        return getAllPlacements(board, n, startColumn);
    }

    */

    /* Optimized */
    List<List<String>> getAllPlacements(ArrayList<String> board, int n, int currCol, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        List<List<String>> res = new ArrayList<>();

        if (currCol == n) {
            res.add(new ArrayList<>(board));
            return res;
        }

        for (int row = 0; row < n; row++){
            if (leftRow[row] == 0 &&
                    lowerDiagonal[row + currCol] == 0 &&
                    upperDiagonal[n - 1 + currCol - row] == 0) {

                String original = board.get(row);
                String modified = original.substring(0, currCol) + 'Q' + original.substring(currCol + 1);
                board.set(row, modified);

                upperDiagonal[n - 1 + currCol - row] = 1;
                leftRow[row] = 1;
                lowerDiagonal[row + currCol] = 1;
                res.addAll(getAllPlacements(board, n, currCol + 1, leftRow, lowerDiagonal, upperDiagonal));
                board.set(row, original);
                leftRow[row] = 0;
                lowerDiagonal[row + currCol] = 0;
                upperDiagonal[n - 1 + currCol - row] = 0;
            }
        }
        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> board = new ArrayList<>();

        char[] row = new char[n];
        // Creating the row
        Arrays.fill(row, '.');

        // Creating the board
        for(int i = 0; i < n; i++) board.add(new String(row));

        int startColumn = 0;
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n - 1];
        int[] lowerDiagonal = new int[2*n - 1];
        return getAllPlacements(board, n, startColumn, leftRow,lowerDiagonal, upperDiagonal);
    }

}
