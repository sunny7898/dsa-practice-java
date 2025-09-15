package recursion;

import java.util.ArrayList;
import java.util.List;

/*
    You are given a string 'STR' containing lowercase English letters from a to z inclusive.
    Your task is to find all non-empty possible subsequences of 'STR'.
*/
public class PrintAllSubsets {
    private static void printSub(int i, int[] arr, ArrayList<Integer> list) {
        if (i == arr.length) {
            System.out.println(list.toString());
            return;
        }
        list.add(arr[i]);
        printSub(i + 1, arr, list);
        list.remove(list.size() - 1);
        printSub(i + 1, arr, list);
    }
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        ArrayList<Integer> list = new ArrayList<>();
        printSub(0, arr, list);
    }

    private static ArrayList<String> getAllSubsequences (String str, String res, int i){
        if (i >= str.length()) {
            ArrayList<String> ans = new ArrayList<>();
            if (!res.isEmpty()) {  // Exclude the empty subsequence
                ans.add(res);
            }
            return ans;
        }

        ArrayList<String> part1 = getAllSubsequences(str, res + str.charAt(i), i + 1);
        ArrayList<String> part2 = getAllSubsequences(str, res, i + 1);

        part1.addAll(part2);
        return part1;
    }
    public static ArrayList<String> subsequences(String str) {
        return getAllSubsequences(str, "", 0);
    }

    private void createSubset1(int idx, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // pick condition
        subset.add(nums[idx]);
        createSubset1(idx + 1, nums, subset, result);
        // not pick condition
        subset.remove(subset.size() - 1);
        createSubset1(idx + 1, nums, subset, result);
    }
    public List<List<Integer>> subsetsMyWay(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        createSubset1(0, nums, new ArrayList<>(), result);
        return result;
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
