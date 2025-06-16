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

        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1);
        /*
            Base case: sum 0 occurs once
            This takes care of the case when prefixSum == k, in that case we need to count
            that subarray as well

            we can handle it in two ways:
            a. If we don't initialize the map with (0, 1) - sum 0, count of such subarr = 1
            in this case we will always check for prefixSum - k in the map. We will not check
            for prefixSum == k, since the above is already taking care of that.

            b. If we don't initialize the map, then we would also need to check for
            prefixSum == k scenario.

            Below code:

            for (int num : nums) {
                prefixSum += num;

                if (prefixSum == k) count++;
                if (mp.containsKey(prefixSum - k)) count += mp.get(prefixSum - k);

                mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
            }

        */
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            int target = prefixSum - k;

            count += prefixSumFrequency.getOrDefault(target, 0);
            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
