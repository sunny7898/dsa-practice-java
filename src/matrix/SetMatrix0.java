package matrix;

public class SetMatrix0 {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Optimal Approach: SC - O(1) TC: O(2*rows*column)
        int col0 = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0)
                        col0 = 0;
                    else
                        matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 1; j < columns; j++){
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0)  {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        // Better approach: TC: O(2*rows*column) SC: O(N+M)

        //     // This will store the column which contains atleast 1 occurence of 0
        //     int[] columnMarker = new int[columns];
        //     // This will store the row which contains atleast 1 occurence of 0
        //     int[] rowMarker = new int[rows];

        //     for (int i = 0; i < rows; i++) {
        //         for (int j = 0; j < columns; j++){

        //             // if there is any one cell containing 0,
        //             // mark that column and row as 1
        //             if (matrix[i][j] == 0) {
        //                 columnMarker[j] = 1;
        //                 rowMarker[i] = 1;
        //             }
        //         }
        //     }

        //     // Use the markers array to individually decide if a cell will contain 0.
        //     for (int i = 0; i < rows; i++) {
        //         for (int j = 0; j < columns; j++){
        //             if (rowMarker[i] == 1 || columnMarker[j] == 1) {
        //                 matrix[i][j] = 0;
        //             }
        //         }
        //     }
        // }
    }
}
