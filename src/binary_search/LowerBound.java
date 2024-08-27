package binary_search;

/*
    Smallest index of a number such that number at that index >= given number OR First value that is greater than
    or equal to given number
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
