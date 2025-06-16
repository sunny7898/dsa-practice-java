package dp.oneD;

import java.util.Arrays;

public class FrogJump {

    /* Recursive */
    private int getMinimumEnergy(int[] arr, int n) {
        // Base case: no energy needed to stay on the first step
        if (n == 0) return 0;

        // Calculate the energy for the previous step
        int oneStep = getMinimumEnergy(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);

        // Calculate the energy for the step before the previous step
        int twoSteps = Integer.MAX_VALUE;
        if (n > 1) twoSteps = getMinimumEnergy(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);

        // Return the minimum of the two possible ways to reach the current step
        return Math.min(oneStep, twoSteps);
    }

    /* Memoization */
    public int minimumEnergy(int[] arr, int N) {
        // Call the recursive function starting from the last step
        return getMinimumEnergy(arr, N - 1);
    }

    private int getMinimumEnergy(int[] arr, int n, int[] dp) {
        // Base case: no energy needed to stay on the first step
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];
        // Calculate the energy for the previous step

        int oneStep = getMinimumEnergy(arr, n - 1, dp) + Math.abs(arr[n] - arr[n - 1]);

        // Calculate the energy for the step before the previous step
        int twoSteps = Integer.MAX_VALUE;
        if (n > 1) twoSteps = getMinimumEnergy(arr, n - 2, dp) + Math.abs(arr[n] - arr[n - 2]);

        // Return the minimum of the two possible ways to reach the current step
        return dp[n] = Math.min(oneStep, twoSteps);
    }

    public int minimumEnergyMemoization(int[] arr, int N) {

        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        // Call the recursive function starting from the last step
        return getMinimumEnergy(arr, N - 1, dp);
    }

    /* Tabulation */
    public int minimumEnergyTabulation(int[] arr, int N) {

        int[] dp = new int[N];

        for (int i = 1; i < N; i++){
            int oneStep = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) twoStep = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);

            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[N - 1];
    }

    /* Tabulation Optimized */
    public int minimumEnergyTabulationOptimized(int[] arr, int N) {

        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < N; i++){

            int oneStep = prev + Math.abs(arr[i] - arr[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) twoStep = prev2 + Math.abs(arr[i] - arr[i - 2]);

            prev2 = prev;
            prev = Math.min(oneStep, twoStep);
        }
        return prev;
    }

}
