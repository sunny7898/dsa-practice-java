package sliding_window;

/*
    Problem statement:
    https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 */

import java.util.HashSet;
import java.util.Set;

public class maxSumDistinctSubarrayLenK {

    public static long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        long maxSum = 0;
        for (int start = 0; start < n - k + 1; start++) {
            Set<Integer> subarray = new HashSet<>();
            long sum = 0;
            for (int j = start; j < start + k; j++) {
                if (subarray.contains(nums[j])) {
                    break;
                } else {
                    subarray.add(nums[j]);
                    sum += nums[j];
                }
            }
            if (subarray.size() == k)
                maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
