package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetAllSubsets {
    List<List<Integer>> getAllSubsets(int[] nums, int n, int idx, ArrayList<Integer> current) {
        List<List<Integer>> res = new ArrayList<>();

        if (idx >= n) {
            res.add(new ArrayList<>(current));
            return res;
        }

        current.add(nums[idx]);
        res.addAll(getAllSubsets(nums, n, idx + 1, current));

        current.remove(current.size() - 1);
        res.addAll(getAllSubsets(nums, n, idx + 1, current));

        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return getAllSubsets(nums, nums.length, 0, new ArrayList<>());
    }
}
