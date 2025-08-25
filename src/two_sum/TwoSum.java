package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Time: O(n) avg, O(n²) worst (HashMap collisions); Space: O(n)
    // Optimized approach in case we want to return the indices.
    public int[] twoSumHashing(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remTarget = target - nums[i];
            if (mp.containsKey(remTarget)) {
                return new int[]{mp.get(remTarget), i};
            }
            mp.put(nums[i], i);
        }
        return null;
    }

    // 2 Pointer approach TC: O(NlogN) SC: O(1)
    // We can't return the index of the elements in this case, because we would have to store them in a map like (ele, its_index)
    // So this is not an optimal approach when we need the indices of the pair.
    public String twoSum2Pointer(int[] nums, int target) {

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return "Yes";
            }
            else if (sum > target) right--;
            else left++;
        }
        return "No";
    }
}
