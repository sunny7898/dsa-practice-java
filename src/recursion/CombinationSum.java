package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /* Brute force: */
    private List<List<Integer>> backtrack(int[] candidates, int idx, ArrayList<Integer> currComb, int target){
        List<List<Integer>> res = new ArrayList<>();

        if (target == 0){
            res.add(new ArrayList<>(currComb));
            return res;
        }
        if (idx == candidates.length || target < 0){
            return res;
        }
        // when picked
        currComb.add(candidates[idx]);
        List<List<Integer>> left = backtrack(candidates, idx, currComb, target - candidates[idx]);
        res.addAll(left);

        currComb.remove(currComb.size() - 1);
        List<List<Integer>> right = backtrack(candidates, idx + 1, currComb, target);
        res.addAll(right);

        return res;

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return backtrack(candidates, 0, new ArrayList<>(), target);
    }
}
