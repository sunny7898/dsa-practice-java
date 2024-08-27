package binary_search;

public class UpperBound {
    //    Smallest index of a number such that number at that index > given number OR
    //    First value that is greater than given number
    public static int findUpperBound(int []arr, int x, int n){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

}
