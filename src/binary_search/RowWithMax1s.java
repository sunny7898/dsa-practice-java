package binary_search;

public class RowWithMax1s {
    // if we want to use upperbound then x would be 0, since upperbound gives us the smallest position where arr[idx] > x
    // i.e. arr[idx] > 0 -> first index of 1.
    private int lowerBound(int[] arr, int n, int x) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int rowWithMax1s(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int idx = -1;
        int maxOnes = 0;
        for (int i = 0; i < m; i++) {
            int countOnes = n - lowerBound(arr[i], n, 1);
            if (countOnes > maxOnes) {
                maxOnes = countOnes;
                idx = i;
            }
        }
        return idx;
    }

    // Brute force:
        /*
            int rows = arr.length;
            int cols = arr[0].length;

            int maxCount = 0;
            int maxRow = -1;

            for (int i = 0; i < rows; i++) {
                int countOnes = 0;
                for (int j = 0; j < cols; j++) countOnes += arr[i][j];

                if (countOnes > maxCount) {
                    maxCount = countOnes;
                    maxRow = i;
                }
            }

            return maxRow;
        */
}