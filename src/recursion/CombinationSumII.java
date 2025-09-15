package recursion;

import java.util.*;

public class CombinationSumII {

    /* Brute force:
        private Set<List<Integer>> backtrack(int[] candidates, int idx, ArrayList<Integer> currComb, int target){
            Set<List<Integer>> res = new HashSet<>();

            if (target == 0){
                ArrayList<Integer> curr = new ArrayList<>(currComb);
                Collections.sort(curr);
                res.add(curr);
                return res;
            }
            if (idx == candidates.length || target < 0){
                return res;
            }
            // when picked
            currComb.add(candidates[idx]);
            Set<List<Integer>> left = backtrack(candidates, idx + 1, currComb, target - candidates[idx]);
            res.addAll(left);

            currComb.remove(currComb.size() - 1);
            Set<List<Integer>> right = backtrack(candidates, idx + 1, currComb, target);
            res.addAll(right);

            return res;
        }
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Set<List<Integer>> res = backtrack(candidates, 0, new ArrayList<>(), target);
            return new ArrayList<>(res);
        }
     */

    /* Optimized */
    private List<List<Integer>> backtrack2(int[] candidates, int idx, ArrayList<Integer> currComb, int target){
        List<List<Integer>> res = new ArrayList<>();

        if (target == 0) {
            res.add(new ArrayList<>(currComb));
            return res;
        }

        if (idx == candidates.length || target < 0){
            return res;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;

            currComb.add(candidates[i]);
            List<List<Integer>> left = backtrack2(candidates, i + 1, currComb, target - candidates[i]);
            res.addAll(left);
            currComb.remove(currComb.size() - 1);
        }
        return res;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtrack2(candidates, 0, new ArrayList<>(), target);
    }
}
