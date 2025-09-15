package recursion;

import java.util.ArrayList;

/*
* https://www.geeksforgeeks.org/problems/subset-sums2234/1
* Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.
*
*/

public class SubsetSums {
    private void backtrack(int[] arr, int sum, int idx, ArrayList<Integer> sumSubset) {

        if (idx == arr.length){
            sumSubset.add(sum);
            return;
        }

        // when picked
        backtrack(arr, sum + arr[idx], idx + 1, sumSubset);

        // when not picked
        backtrack(arr, sum, idx + 1, sumSubset);

    }
    public ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> sumSubset = new ArrayList<>();
        backtrack(arr, 0, 0, sumSubset);
        return sumSubset;

    }
}
