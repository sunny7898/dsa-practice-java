package recursion;

import java.util.ArrayList;

public class RatInMaze {
    private ArrayList<String> getAllPaths(int[][] mat, int n, int[][] visited, int row, int col, String current) {
        ArrayList<String> res = new ArrayList<>();

        if (row == n-1 && col == n-1) {
            res.add(current);
            return res;
        }

        // Explore all 4 directions in lexicographical order

        // down
        if (row < n-1 && visited[row + 1][col] != -1 && mat[row + 1][col] == 1) {
            visited[row][col] = -1;
            res.addAll(getAllPaths(mat, n, visited, row + 1, col, current + "D"));
            visited[row][col] = 1;
        }

        // left
        if (col > 0 && visited[row][col - 1] != -1 && mat[row][col - 1] == 1) {
            visited[row][col] = -1;
            res.addAll(getAllPaths(mat, n, visited, row, col - 1, current + "L"));
            visited[row][col] = 1;
        }

        // up
        if (row > 0 && visited[row-1][col] != -1 && mat[row-1][col] == 1) {
            visited[row][col] = -1;
            res.addAll(getAllPaths(mat, n, visited, row - 1, col, current + "U"));
            visited[row][col] = 1;
        }

        // right
        if (col < n-1 && visited[row][col + 1] != -1 && mat[row][col + 1] == 1) {
            visited[row][col] = -1;
            res.addAll(getAllPaths(mat, n, visited, row, col + 1, current + "R"));
            visited[row][col] = 1;
        }

        return res;
    }

    public ArrayList<String> findPath(int[][] mat) {

        int n = mat.length;
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) return new ArrayList<String>();

        int[][] visited = new int[n][n];
        for (int i = 0; i < mat.length; i++) visited[i] = mat[i].clone();
        return getAllPaths(mat, n, visited, 0, 0, "");
    }
}
