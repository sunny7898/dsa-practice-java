package recursion;

import java.util.*;

public class CombinationSumII {

    /* Brute force:
    Set<ArrayList<Integer>> getCombinations(int[] nums, int n, int target, int idx, ArrayList<Integer> currentComb) {
        Set<ArrayList<Integer>> res = new HashSet<>();

        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(currentComb);
            Collections.sort(temp);

            res.add(temp);
            return res;
        }

        if (idx >= n || target < 0) return res;

        // when picked
        currentComb.add(nums[idx]);
        res.addAll(getCombinations(nums, n, target - nums[idx], idx + 1, currentComb));

        currentComb.remove(currentComb.size() - 1);
        res.addAll(getCombinations(nums, n, target, idx + 1, currentComb));

        return res;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<ArrayList<Integer>> res = getCombinations(candidates, candidates.length, target, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }
     */

    /* Optimized */
    public List<List<Integer>> findCombinations(int[] arr, int n, int target, int idx, ArrayList<Integer> current) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return res;
        }

        for (int i = idx; i < n; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            current.add(arr[i]);
            res.addAll(findCombinations(arr, n, target-arr[i], i + 1, current));
            current.remove(current.size() - 1);
        }
        return res;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findCombinations(candidates, candidates.length, target, 0, new ArrayList<>());
    }
}
