package twoPointer;

import java.util.Arrays;

public class CountSubsequencesThatSatisfyGivenSumCondition {
    // BRUTE FORCE: 2^n
    private int backtrack(int idx, int minV, int maxV, int[] nums, int target) {
        int MODULO = 1000000007;
        int count = 0;
        if (idx == nums.length){
            if (minV == Integer.MAX_VALUE && maxV == Integer.MIN_VALUE) return 0;
            long sum = (long) minV + (long) maxV;
            if (sum <= (long) target) {
                count++;
            }
            return count;
        }

        int currMinV = minV;
        int currMaxV = maxV;

        // when picked
        if (nums[idx] < minV) minV = nums[idx];
        if (nums[idx] > maxV) maxV = nums[idx];
        int countWhenPicked = backtrack(idx + 1, minV, maxV, nums, target);

        // when not picked
        int countWhenNotPicked = backtrack(idx + 1, currMinV, currMaxV, nums, target);
        int res = countWhenPicked + countWhenNotPicked;
        if (res >= MODULO) res -= MODULO;
        return res;
    }
    public int numSubseqBrute(int[] nums, int target) {
        return backtrack(0, Integer.MAX_VALUE, Integer.MIN_VALUE, nums, target);
    }

    // Optimized: Check excel sheet
    public int numSubseq(int[] nums, int target) {
        int MOD = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++){
            power[i] = (int) (((long) power[i - 1] * 2) % MOD);
        }

        int count = 0, left = 0,  right = n - 1;
        while (left <= right){
            if (nums[left] + nums[right] <= target){
                count += power[right - left];
                if (count >= MOD) count -= MOD;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
