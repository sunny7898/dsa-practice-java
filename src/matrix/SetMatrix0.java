package matrix;

public class SetMatrix0 {
    // Better approach: TC: O(MxN) SC: O(N+M)
    /*
        Approach:
        This will store the column which contains atleast 1 occurence of 0
            int[] col_marker = new int[columns];
        This will store the row which contains atleast 1 occurence of 0
            int[] row_marker = new int[rows];
        [
                        [1,0,1,1]  <--- row_marker
        col_marker ---> [1][0,1,2,0]
                        [0][3,4,5,2]  ==>
                        [1][1,3,0,5]

                        [1,0,1,1]
                        [1][0,0,0,0]
                        [0][0,4,0,0]
                        [1][0,0,0,0]
        ]

    */
    public void setZeroesBetter(int[][] matrix) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        // In Java, these are automatically initialized with 0.
        int[] row_marker = new int[col_num];
        int[] col_marker = new int[row_num];

        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                if (matrix[i][j] == 0) {
                    row_marker[j] = 1;
                    col_marker[i] = 1;
                }
            }
        }

        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                if (row_marker[j] == 1 || col_marker[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimized: TC: O(MxN) SC: O(N+M)
    /*
        Approach:
        Step 1: Assume the 0th row as col_marker and 0th column as row_marker
        Step 2: Since there is an overlap for cell 0,0 we will use a separate variable to keep
                track of cell_marker[0] -- col_0
        Step 3: Iterate the matrix, and set row_marker and col_marker 0 wherever the element
                in the cell is 0
        Step 4: Iterate the matrix from 1,1 to mxn and set 0 wherever either of row_marker or
                col_marker for that i and j is 0
        Step 5: Start marking 0 in col_marker since its element value depends upon row_marker array
        Step 6: Start with row_marker
        [
                    [0]  <-- col_0
        row_marker --> [0],[1,0,0]]  <--- col_marker
                    [3], 4,5,2]    ===>
                    [0], 3,0,5]

                    [0]
                    [0],[0,0,0]]
                    [0], 4,0,0]
                    [0], 0,0,0]
        ]

    */
    public void setZeroes(int[][] matrix) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int col_0 = 1;

        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // row_marker
                    if (j == 0) {
                        col_0 = 0;
                    } else {
                        matrix[0][j] = 0;  // col_marker
                    }


                }
            }
        }

        for (int i = 1; i < row_num; i++) {
            for (int j = 1; j < col_num; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0){
            for(int j = 1; j < col_num; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col_0 == 0) {
            for(int i = 0; i < row_num; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

/*

Better:
    [
        [1,0,1,1]
        [1][0,1,2,0]
        [0][3,4,5,2]
        [1][1,3,0,5]

        [1,0,1,1]
        [1][0,0,0,0]
        [0][0,4,0,0]
        [1][0,0,0,0]
    ]

Optimized:
    [
               [0]  <-- col_0
row_marker --> [0],[1,0,0]]  <--- col_marker
               [3], 4,5,2]
               [0], 3,0,5]

               [0]
               [0],[0,0,0]]
               [0], 4,0,0]
               [0], 0,0,0]
    ]


*/
