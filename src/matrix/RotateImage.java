package matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        // Brute force: TC : O(N^2) SC: O(N^2)
        // int[][] ans = new int[rows][columns];
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < columns; j++) {
        //         ans[j][columns - 1 - i] = matrix[i][j];
        //     }
        // }
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < columns; j++) {
        //         matrix[i][j] = ans[i][j];
        //     }
        // }

        // Optimized approach: SC: O(1)
        // Step 1: Transpose:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse element in each row
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = columns - 1;
            while (left <= right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
