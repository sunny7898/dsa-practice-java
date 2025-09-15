package recursion;

/*
* https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
*
* Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[]
* with sum equal to given sum.
 * */

public class SubsetSumProblem {
    private static Boolean backtrack(int[] arr, int idx, int tSum) {

        if (tSum == 0) return true;
        if (idx == arr.length || tSum < 0) return false;

        return backtrack(arr, idx + 1, tSum - arr[idx]) || backtrack(arr, idx + 1, tSum);
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        return backtrack(arr, 0, sum);
    }
}
