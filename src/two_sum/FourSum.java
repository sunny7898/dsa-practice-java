package two_sum;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSumBrute(int[] nums, int target) {
        int n = nums.length;

        Set<ArrayList<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int p = k + 1; p < n; p++) {
                        if (nums[i] + nums[j] + nums[k] + nums[p] == target) {
                            ArrayList<Integer> quadruplet = new ArrayList(
                                    Arrays.asList(nums[i], nums[j], nums[k], nums[p]));
                            Collections.sort(quadruplet);
                            st.add(quadruplet);
                        }
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(st);
        return res;
    }

    public List<List<Integer>> fourSumHashingBetter(int[] nums, int target) {
        int n = nums.length;

        Set<ArrayList<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                Set<Integer> temp = new HashSet<>();
                for (int k = j + 1; k < n; k++) {

                    int fourth = target - (nums[i] + nums[j] + nums[k]);

                    if (temp.contains(fourth)) {
                        ArrayList<Integer> quadruplet = new ArrayList(Arrays.asList(nums[i], nums[j], nums[k], fourth));
                        Collections.sort(quadruplet);
                        st.add(quadruplet);
                    }

                    temp.add(nums[k]);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(st);
        return res;
    }

    /*
        Time: O(n²) to build pairs plus O(n² × k) to find quadruplets (k = avg pairs per sum), worst O(n⁴);
        Space: O(n²) for storing pairs and up to O(n⁴) for results in worst case.
    */
    public List<List<Integer>> fourSumHashingOptimized(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Improve the hashing to store the pairSum, in order to reduce two loops.
        Map<Integer, List<int[]>> pairSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                /*
                 if (!pairSum.containsKey(sum)) {
                     pairSum.put(sum, new ArrayList<>());
                 }
                 pairSum.get(sum).add(new int[] { i, j });
                */

                pairSum.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int sum = nums[i] + nums[j];
                int remSum = target - sum;

                if (pairSum.containsKey(remSum)) {
                    for (int[] pair: pairSum.get(remSum)) {
                        int x = pair[0], y = pair[1];

                        if (y < i) { // ensures x < y < i < j, avoids all overlaps
                            List<Integer> quad = Arrays.asList(nums[x], nums[y], nums[i], nums[j]);
                            st.add(quad);
                        }
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(st);
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;

                int m = j + 1;
                int p = n - 1;

                while (m < p) {
                    long sum = nums[i] + nums[j];
                    sum += nums[m] + nums[p];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[p]));
                        while (m < p && nums[m] == nums[m + 1]) m++;
                        while (p > m && nums[p] == nums[p - 1]) p--;

                        m++;
                        p--;
                    } else if (sum > target) p--;
                    else m++;
                }
            }
        }
        return res;
    }

}
