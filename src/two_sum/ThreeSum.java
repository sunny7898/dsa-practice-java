package two_sum;

import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSumBrute(int[] nums) {
        int n = nums.length;

        Set<ArrayList<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));

                        // Handling duplicates
                        Collections.sort(triplet);
                        st.add(triplet);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList(st);
        return res;
    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;

        Set<ArrayList<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {

            Set<Integer> temp = new HashSet<>();
            for (int j = i + 1; j < n; j++) {

                int third = -(nums[i] + nums[j]);
                if (temp.contains(third)) {
                    ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));

                    // Handling duplicates;
                    Collections.sort(triplet);
                    st.add(triplet);
                } else {
                    temp.add(nums[j]);
                }
            }
        }

        List<List<Integer>> res = new ArrayList(st);
        return res;
    }


    // Fix the i and use two pointer in the remaining, skip the elements already a part of triplet for i, j , k
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (k > j && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}