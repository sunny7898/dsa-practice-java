package recursion;

public class CountSubsetWithSumK {
    private static int backtrack(int[] num, int idx, int sum, int target) {
        int mod = 1000000007;

        if(sum > target) return 0;
        if (sum == target) return 1;

        if (idx == num.length) return (sum == target) ? 1 : 0;

        // when picked
        int countLeft = backtrack(num, idx + 1, sum + num[idx], target) % mod;

        // when not picked
        int countRight = backtrack(num, idx + 1, sum, target) % mod;

        int res = (countLeft + countRight) % mod;
        return res;
    }
    public static int findWays(int num[], int target) {
        return backtrack(num, 0, 0, target);
    }
}
