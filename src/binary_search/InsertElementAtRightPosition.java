package binary_search;

public class InsertElementAtRightPosition {


    // Uses the logic of finding the lowerbound of a num in the array
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int ans = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return ans = mid;
            }
            else if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return ans;
    }
}
