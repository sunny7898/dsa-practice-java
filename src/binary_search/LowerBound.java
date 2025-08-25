package binary_search;

/*
    Smallest index of a number such that number at that index >= given number OR First value that is greater than
    or equal to given number

    It returns the smallest index where arr[idx] >= x.

    If x = 1 → it returns the index of the first 1 in the row.
    If no 1 exists → it returns n (just past the last element).
*/


public class LowerBound {
    public int findLowerBound(int[] arr, int n, int x) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
