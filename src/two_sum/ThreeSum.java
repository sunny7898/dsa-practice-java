package two_sum;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        // BF Approach:
        // Set<List<Integer>> st = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 ArrayList<Integer> triplet = new ArrayList<>();
        //                 triplet.addAll(Arrays.asList(nums[i], nums[j], nums[k]));

        //                 // Taking care of duplicate triplets
        //                 Collections.sort(triplet);
        //                 st.add(triplet);
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> res = new ArrayList<>();
        // res.addAll(st);

        // Better approach: TC: O(N^2) SC: O(N^3)
        // Set<List<Integer>> resSet = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     Set<Integer> temp = new HashSet<>();
        //     for (int j = i + 1; j < n; j++) {
        //         int numsK = -(nums[i] + nums[j]);
        //         if (temp.contains(numsK)) {
        //             ArrayList<Integer> triplet = new ArrayList<>();
        //             triplet.addAll(Arrays.asList(nums[i], nums[j], numsK));
        //             Collections.sort(triplet);
        //             resSet.add(triplet);
        //         } else {
        //             temp.add(nums[j]);
        //         }
        //     }

        // }
        // List<List<Integer>> res = new ArrayList<>();
        // res.addAll(resSet);

        // Optimzed approach. TC: O(NLogN + N^3) SC: O(1)
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 1: Fix the i
            // Step 2: Search for j and k elements from i + 1 to n
            // Since array is sorted, use two pointer approach
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicates
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;

                }
            }
        }
        return res;
    }
}
