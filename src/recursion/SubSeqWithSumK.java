package recursion;

import java.util.ArrayList;

public class SubSeqWithSumK {

    /* Brute force:
       - Once the subsequence of target Sum is found, this will return and won't continue the function calls
       How ?
       Reason 1:
       In the base case, we stop the recursive calls as soon as we encounter our desired sum
       This leads to not exploring all the possible subsequences.

       Reason 2:
       For the second function call, we first check if we have encountered our desired sum from the first call
       If only when we haven't, we call the second function call.
    */
    private static boolean checkIfSubSeqFound(int[] arr, int n, int i, int sum, int targetSum) {

        if (sum == targetSum) return true;
        if (i >= n) return false;

        boolean sumFound = checkIfSubSeqFound(arr, n, i + 1, sum + arr[i], targetSum);
        if (sumFound) return true;
        return checkIfSubSeqFound(arr, n, i + 1, sum, targetSum);
    }

    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        int idx = 0;
        int sum = 0;
        return checkIfSubSeqFound(arr, N, idx, sum, K);
    }

    /*
        In case we want to return all the subsequences whose sum == targetSum.
        We would have to explore all the subsequences
     */
    private static void getAllSubSequencesWithSumKHelper(int[] arr, int n, int targetSum, ArrayList<ArrayList<Integer>> res,
                                                           ArrayList<Integer> currentList, int idx, int sum ) {
        if (idx == n) {
            if (sum == targetSum) res.add(new ArrayList<>(currentList));
            return;
        }
        getAllSubSequencesWithSumKHelper(arr, n, targetSum, res, currentList, idx + 1, sum);
        currentList.add(arr[idx]);
        getAllSubSequencesWithSumKHelper(arr, n, targetSum, res, currentList, idx + 1, sum + arr[idx]);
    }

    public static ArrayList<ArrayList<Integer>> getAllSubSequencesWithSumK(int N, int[] arr, int K) {
        int idx = 0;
        int sum = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getAllSubSequencesWithSumKHelper(arr, N, K, res, new ArrayList<>(), idx, sum);
        return res;
    }

    private static void printAllSubSequencesWithSumKHelper(int[] arr, int n, int targetSum, ArrayList<Integer> currentList, int idx, int sum ) {
        if (idx == n) {
            if (sum == targetSum) System.out.println(currentList);
            return;
        }
        printAllSubSequencesWithSumKHelper(arr, n, targetSum, currentList, idx + 1, sum);
        currentList.add(arr[idx]);
        printAllSubSequencesWithSumKHelper(arr, n, targetSum, currentList, idx + 1, sum + arr[idx]);
    }

    public static void printAllSubSequencesWithSumK(int N, int[] arr, int K) {
        int idx = 0;
        int sum = 0;
        printAllSubSequencesWithSumKHelper(arr, N, K, new ArrayList<>(), idx, sum);
    }

    private static int countAllSubSequencesWithSumKHelper(int[] arr, int n, int targetSum, int idx, int sum ) {
        if (idx == n) {
            if (sum == targetSum) return 1;
            return 0;
        }
        int left = countAllSubSequencesWithSumKHelper(arr, n, targetSum, idx + 1, sum);
        int right = countAllSubSequencesWithSumKHelper(arr, n, targetSum,idx + 1, sum + arr[idx]);
        return left + right;
    }

    public static int countAllSubSequencesWithSumK(int N, int[] arr, int K) {
        int idx = 0;
        int sum = 0;
        return countAllSubSequencesWithSumKHelper(arr, N, K, idx, sum);
    }
}
