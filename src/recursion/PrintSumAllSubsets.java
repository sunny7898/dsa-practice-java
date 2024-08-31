package recursion;

import java.util.ArrayList;

public class PrintSumAllSubsets {
    ArrayList<Integer> getAllSubsetSum(ArrayList<Integer> arr, int n, int idx, int sum) {

        ArrayList<Integer> res = new ArrayList<>();

        if(idx >= n) {
            res.add(sum);
            return res;
        }

        // when picked up
        res.addAll(getAllSubsetSum(arr, n, idx + 1, sum + arr.get(idx)));
        // when not picked up
        res.addAll(getAllSubsetSum(arr, n, idx + 1, sum));

        return res;
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        return getAllSubsetSum(arr, n, 0, 0);
    }
}
