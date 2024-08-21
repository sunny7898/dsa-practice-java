package binary_search;

public class RowWithMax1s {
    private int lowerBound(int[][] arr, int i, int n, int x) {

        int ans = n;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[i][mid] >= x) {
                ans = mid;

                // look for smaller index on left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int rowWithMax1s(int arr[][]) {

        int rows = arr.length;
        int cols = arr[0].length;

        int maxCount = 0;
        int maxRow = -1;
        for (int i = 0; i < rows; i++) {

            int countOnes = cols - lowerBound(arr, i, cols, 1);
            if (countOnes > maxCount) {
                maxCount = countOnes;
                maxRow = i;
            }
        }
        return maxRow;

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
}
