package binary_search;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) return mid;

            // Identify the sorted half
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
