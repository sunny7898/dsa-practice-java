package sliding_window;

/*
    Problem statement:
    https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 */

import java.util.HashSet;
import java.util.Set;

public class maxSumDistinctSubarrayLenK {

    /*

    Approach 1: Brute force:

    public long maximumSubarraySum(int[] nums, int k) {

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
    }*/

    /* Optimized: Sliding - window*/

    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        long maxWindowSum = 0;
        long currentSum = 0;
        Set<Integer> subarr = new HashSet<>();
        int start = 0;
        long currWindowSum = 0;

        for (int end = 0; end < n; end++) {
            while (subarr.contains(nums[end])) {
                subarr.remove(nums[start]);
                currWindowSum -= nums[start];
                start++;
            }

            subarr.add(nums[end]);
            currWindowSum += nums[end];

            if (end - start + 1 > k) {
                subarr.remove(nums[start]);
                currWindowSum -= nums[start];
                start++;
            }

            if (end - start + 1 == k) {
                maxWindowSum = Math.max(currWindowSum, maxWindowSum);
            }

        }
        return maxWindowSum;
    }
}
