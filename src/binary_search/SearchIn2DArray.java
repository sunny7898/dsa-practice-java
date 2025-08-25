package binary_search;

public class SearchIn2DArray {
    /*
        Since the matrix is row-wise sorted and each row has n elements,
        I can flatten it into a single array. If I pick an index mid,
        then mid / n gives me the row (because every row has n elements),
        and mid % n gives me the column (the offset within that row).
        That way I can map any 1D index back to 2D coordinates.

        Every row has n elements.
        So if I divide mid by n, that tells me how many full rows are passed.
        Hence: row = mid / n

        Figure out the column
        After filling row complete rows, the leftover is the position inside the current row.
        That’s just the remainder: col = mid % n
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = (m * n - 1);
        while (low <= high) {
            int mid = (low + high) / 2;

            int rowNum = mid / n;
            int colNum = mid % n;

            if (matrix[rowNum][colNum] == target) return true;
            else if (matrix[rowNum][colNum] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
        // Better - O(m + log2n)
        /*
            int targetRow = -1;
            for (int i = 0; i < m; i++) {
                if (target >= matrix[i][0] && target <= matrix[i][n - 1]){
                    targetRow = i;
                    break;
                }
            }
            if (targetRow == -1) return false;

            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (matrix[targetRow][mid] == target) return true;

                if (matrix[targetRow][mid] < target) low = mid + 1;
                else high = mid - 1;
            }

            return false;
        */
    }
}
