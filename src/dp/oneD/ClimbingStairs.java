package dp.oneD;

import java.util.Arrays;

public class ClimbingStairs {

    /* BF: Recursion */
    private int countUniqueWays(int n, int position) {
        if (position > n) return 0;
        if (position == n) return 1;

        return countUniqueWays(n, position + 1) + countUniqueWays(n, position + 2);
    }
    public int climbStairsRecursion(int n) {
        return countUniqueWays(n, 0);
    }

    /* Memoization */
    private int countUniqueWays(int n, int[] dp, int pos) {
        if (pos > n) return 0;
        if (pos == n) return 1;

        if (dp[pos] != -1) return dp[pos];
        return dp[pos] = countUniqueWays(n, dp, pos + 1) + countUniqueWays(n, dp, pos + 2);
    }
    public int climbStairsMemoization(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countUniqueWays(n, dp, 0);
    }

    /* Tabulation */
    public int climbStairsTabulation(int n) {
        // Steps allowed to climb at once
        int k1 = 1, k2 = 2;

        int[] dp = new int[n + 1];
        /*
         * Starting from 0
         * To reach to k1th - 0th step means dp[0] = 1 (1 possible way)
         * To reach to k2th - 1st step means dp[1] = 1 (1 possible way)
         */

        dp[0] = 1;

        if (n >= k1) dp[k1] = 1;
        if (n >= k2) dp[k2] = 1;

        for(int i = k2; i <= n; i++) {
            dp[i] = dp[i - k1] + dp[i - k2];
        }

        return dp[n];
    }
}
