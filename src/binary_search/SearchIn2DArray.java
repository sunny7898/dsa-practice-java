package binary_search;

public class SearchIn2DArray {
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
