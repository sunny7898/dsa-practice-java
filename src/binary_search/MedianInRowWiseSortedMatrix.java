package binary_search;

import java.util.Arrays;

public class MedianInRowWiseSortedMatrix {
    // TC: O(n*m) + O(n*m + Log(n*m))
    public int medianBrute(int[][] mat) {
        int m = mat[0].length;
        int n = mat.length;

        int[] flatArr = new int[n*m];
        int k = 0;
        for (int[] row : mat)
            for (int j = 0; j < m; j++) {
                flatArr[k++] = row[j];
            }
        Arrays.sort(flatArr);
        return flatArr[(n*m)/2];
    }

    //Optimized: TC: O(n + Log2(maxEle) * n * Log2(m))

    private int getCountUsingUpperBound(int[] row, int m, int target) {
        int left = 0, right = m - 1;
        int ans = m;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (row[mid] > target){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    private int countSmallerEqualsThenMid(int[][] mat, int n, int m, int mid) {
        int count = 0;
        for (int[] row: mat) {
            count += getCountUsingUpperBound(row, m, mid);
        }
        return count;
    }
    public int median(int[][] mat) {
        int m = mat[0].length;
        int n = mat.length;

        int low = 2001, high = 0;
        for (int[] row: mat) {
            low = Math.min(low, row[0]);
            high = Math.max(high, row[m-1]);
        }

        int req = (n*m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            int smallEquals = countSmallerEqualsThenMid(mat, n, m, mid);
            if (smallEquals <= req) {
                low = mid + 1;  // because we want it to be > req (for an eligible median)
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
}
