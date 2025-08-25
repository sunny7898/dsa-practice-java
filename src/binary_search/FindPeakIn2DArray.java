package binary_search;

public class FindPeakIn2DArray {
    private int getRowContainingMaxForGivenMid(int[][] mat, int m, int n, int mid){
        int idx = -1;
        int maxE = 0;
        for (int i = 0; i < m; i++) {
            if (mat[i][mid] > maxE) {
                maxE = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int left  = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            int row = getRowContainingMaxForGivenMid(mat, m, n, mid);

            int leftOfMid = mid > 0 ? mat[row][mid - 1] : -1;
            int rightOfMid = mid < n-1 ? mat[row][mid + 1] : -1;
            int atMid = mat[row][mid];

            if (atMid > leftOfMid && atMid > rightOfMid) return new int[]{row, mid};

            if (leftOfMid > atMid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
