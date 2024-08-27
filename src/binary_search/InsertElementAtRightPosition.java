package binary_search;

public class InsertElementAtRightPosition {

    // Uses the logic of finding the lowerbound of a num in the array
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return high + 1;
    }
}
