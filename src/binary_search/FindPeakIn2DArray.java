package binary_search;

public class FindPeakIn2DArray {
    private int getMaximumIdx(int[][] mat, int rows, int cols, int mid) {
        int maxEle = -1;
        int maxEleIdx = -1;
        for (int i = 0; i < rows; i++) {
            if (mat[i][mid] > maxEle) {
                maxEle = mat[i][mid];
                maxEleIdx = i;
            }
        }
        return maxEleIdx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxInColIdx = getMaximumIdx(mat, m, n, mid);

            int left = mid - 1 >= 0 ? mat[maxInColIdx][mid - 1] : -1;
            int right = mid + 1 < n ? mat[maxInColIdx][mid + 1] : -1;
            int curr = mat[maxInColIdx][mid];

            if (curr > left && curr > right) return new int[]{maxInColIdx, mid};
            else if (curr > left) low = mid + 1;
            else if (curr < left) high = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
