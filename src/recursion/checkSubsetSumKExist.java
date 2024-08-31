package recursion;

    /*
        Given an array of non-negative integers, and a value sum,
        determine if there is a subset of the given set with sum equal to given sum.
    */
public class checkSubsetSumKExist {
    static boolean checkIfSubsetSumExist(int[] arr, int n, int sum, int idx) {

        if (sum == 0) return true;
        if (idx >= n || sum < 0) return false;

        if (checkIfSubsetSumExist(arr, n, sum - arr[idx], idx + 1)) return true;
        return checkIfSubsetSumExist(arr, n, sum, idx + 1);
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        return checkIfSubsetSumExist(arr, N, sum, 0);
    }
}
