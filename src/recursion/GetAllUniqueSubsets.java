package recursion;

import java.util.*;

public class GetAllUniqueSubsets {

    /* Brute force:

    Time Complexity:
        Number of Recursive Calls:
            The function explores all possible subsets of the input array nums.
            Since each element can either be included or excluded, the number of recursive calls is 2^n, where n is the length of nums.
        Sorting Each Subset:
            Inside the base case (if (idx >= n)), the current list is copied and sorted before being added to the Set.
            Sorting a list takes O(k log k) time, where k is the length of the current subset. In the worst case, k can be n, so the sorting step takes O(n log n) time.
        Overall Time Complexity:
            For each of the 2^n subsets, sorting takes O(n log n) time.
            Therefore, the overall time complexity is O(2^n * n log n).

    Space Complexity:
        Recursion Stack:
            The maximum depth of the recursion stack is O(n) because the recursive function is called once for each element in the array.
            Temporary Storage (Subset Storage):
            The function stores each subset in a Set. In the worst case, there can be O(2^n) subsets, and each subset can have up to n elements.
            Therefore, the space complexity for storing all subsets is O(2^n * n).
        Additional Space (Sorting and Copying):
            The space complexity for sorting each subset and creating a copy is included in the subset storage space mentioned above.

        Overall Space Complexity:
        The total space complexity is O(2^n * n) for storing the subsets plus O(n) for the recursion stack, which results in O(2^n * n).

    Set<ArrayList<Integer>> getSubsets(int[] nums, int n, int idx, ArrayList<Integer> current) {
        Set<ArrayList<Integer>> res = new HashSet<>();

        if (idx >= n) {
            ArrayList<Integer> temp = new ArrayList<>(current);
            Collections.sort(temp);
            res.add(temp);
            return res;
        }

        // when picked
        current.add(nums[idx]);
        res.addAll(getSubsets(nums, n, idx + 1, current));

        // when not picked
        current.remove(current.size() - 1);
        res.addAll(getSubsets(nums, n, idx + 1, current));

        return res;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<ArrayList<Integer>> ans = getSubsets(nums, nums.length, 0, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    */

}
