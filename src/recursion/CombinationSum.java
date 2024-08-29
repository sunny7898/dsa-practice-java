package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    /* Brute force: */
    List<List<Integer>> getCombinations(int[] nums, int n, int target, int idx, ArrayList<Integer> currentCombination) {

        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            res.add(new ArrayList<>(currentCombination));
            return res;
        }

        if (idx >= n || target < 0) return res;

        // choice 1 - when element at index idx is picked
        currentCombination.add(nums[idx]);
        res.addAll(getCombinations(nums, n, target-nums[idx], idx, currentCombination));

        // choice 2 - when element is not picked up
        currentCombination.remove(currentCombination.size() - 1);
        res.addAll(getCombinations(nums, n, target, idx + 1, currentCombination));

        return res;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return getCombinations(candidates, candidates.length, target, 0, new ArrayList<>());
    }
}
