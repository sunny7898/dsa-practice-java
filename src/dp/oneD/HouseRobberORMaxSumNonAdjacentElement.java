package dp.oneD;

import java.util.Arrays;

public class HouseRobberORMaxSumNonAdjacentElement {

    /* Recursion */
    private int getMaxAmount(int[] nums, int n) {

        // if we are reaching to idx = 0, means we haven't picked idx = 1
        // hence we can pick this element
        if (n == 0) return nums[n];

        // not a valid index
        if (n < 0) return 0;

        int ifPicked = nums[n] + getMaxAmount(nums, n - 2);
        int ifNotPicked = 0 + getMaxAmount(nums, n - 1);

        return Math.max(ifPicked, ifNotPicked);
    }

    public int rob(int[] nums) {
        return getMaxAmount(nums, nums.length - 1);
    }

    /* Memoization */
    private int getMaxAmount(int[] nums, int n, int[] dp) {

        // if we are reaching to idx = 0, means we haven't picked idx = 1
        // hence we can pick this element
        if (n == 0) return nums[n];

        // not a valid index
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        int ifPicked = nums[n] + getMaxAmount(nums, n - 2, dp);
        int ifNotPicked = 0 + getMaxAmount(nums, n - 1, dp);

        return dp[n] = Math.max(ifPicked, ifNotPicked);
    }

    public int robMemoization(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMaxAmount(nums, nums.length - 1, dp);
    }

    /* Tabulation */
    public int robTabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int ifPicked = nums[i];
            if (i > 1) ifPicked += dp[i - 2];

            int ifNotPicked = 0 + dp[i - 1];

            dp[i] = Math.max(ifPicked, ifNotPicked);
        }
        return dp[n - 1];
    }

    /* Tabulation Optimized*/
    public int robTabulationOptimized(int[] nums) {
        int n = nums.length;

        // Base cases
        int prev = nums[0];
        int prev2 = 0;  // represent idx = -1

        for (int i = 1; i < n; i++) {
            int ifPicked = nums[i];
            if (i > 1) ifPicked += prev2;

            int ifNotPicked = 0 + prev;

            prev2 = prev;
            prev = Math.max(ifPicked, ifNotPicked);
        }
        return prev;
    }
}
