package dp.twoDThreeDGrid;

public class UniquePaths {

    /* Recursion */
    private int countPaths(int m, int n, int curr_i, int curr_j){

        if (curr_i == m - 1 && curr_j == n - 1) {
            return 1;
        }

        if (curr_j == n || curr_i == m) return 0;

        int right = countPaths(m, n, curr_i, curr_j + 1);
        int down = countPaths(m, n, curr_i + 1, curr_j);

        return right + down;
    }

    public int uniquePaths(int m, int n) {
        return countPaths(m, n, 0, 0);
    }
}
