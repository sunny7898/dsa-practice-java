package binary_search;

public class SearchIn2DArrayII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Start from top - rightmost position
        // on the left of it, are the elements smaller then this element
        // on the down of it, are the elements larger then this element
        // will work also in case we start at bottom - leftmost position

        // In total we are travelling m steps downwards and n steps right to left Hence TC: O(m + n)

        int row = 0, col = n - 1;

        while (row < m && col >= 0) {

            if (matrix[row][col] == target) return true;

            if (matrix[row][col] > target) col--;
            else if (matrix[row][col] < target) row++;
        }
        return false;

    }
}
