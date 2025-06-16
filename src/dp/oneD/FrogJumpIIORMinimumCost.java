package dp.oneD;

import java.util.Arrays;

public class FrogJumpIIORMinimumCost {

    /* Recursion */
    private int getMinimumCost(int[] arr, int n, int k) {
        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++){
            if (n - i >= 0) {
                int res = getMinimumCost(arr, n - i, k) + Math.abs(arr[n] - arr[n - i]);
                ans = Math.min(ans, res);
            }
        }
        return ans;
    }

    public int minimizeCost(int[] arr, int k) {
        return getMinimumCost(arr, arr.length - 1, k);
    }

    /* Memoization */
    private int getMinimumCost(int[] arr, int n, int k, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++){
            if (n - i >= 0) {
                int res = getMinimumCost(arr, n - i, k, dp) + Math.abs(arr[n] - arr[n - i]);
                ans = Math.min(ans, res);
            }
        }
        return dp[n] = ans;
    }

    public int minimizeCostMemoization(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMinimumCost(arr, n - 1, k, dp);
    }

    /* Tabulation */
    public int minimizeCostTabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = 0;
        for(int i = 1; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++){
                if (i - j >= 0) {
                    int res = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    dp[i] = Math.min(dp[i], res);
                }
            }
        }
        return dp[n - 1];
    }
}
