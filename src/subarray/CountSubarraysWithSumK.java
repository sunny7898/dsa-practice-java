package subarray;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumK {
    public int subarraySum(int[] nums, int k) {

        // Brute:
        /*
            int n = nums.length;
            int count = 0;

            for (int start = 0; start < n; start++) {
                for (int end = start; end < n; end++) {
                    int sum = 0;
                    for (int j = start; j <= end; j++) {
                        sum += nums[j];
                    }
                    if (sum == k) count++;
                }
            }
            return count;
        */

        // Better:
        /*
            int n = nums.length;
            int count = 0;
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int end = start; end < n; end++) {
                    sum += nums[end];
                    if (sum == k) count++;
                }
            }
            return count;
        */

        // Optimized TC: O(N) SC: O(N)

        int n = nums.length;  // Length of the input array
        int count = 0;  // Initialize a counter to keep track of subarrays that sum to k

        Map<Integer, Integer> mp = new HashMap<>();  // HashMap to store the frequency of each prefix sum encountered
        int prefixSum = 0;
        for (int i = 0; i < n;  i++) {
            prefixSum += nums[i];
            if (prefixSum == k) count++;  // If the current prefixSum equals k, we found a valid subarray

            // If there exists a subarray with sum = (current prefixSum - k),
            // it indicates that there is a subarray that sums to k
            if (mp.containsKey(prefixSum - k)) count += mp.get(prefixSum - k);

            // Store or update the frequency of the current prefixSum in the HashMap
            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }

        return count;  // Return the total count of subarrays that sum to k
    }
}
