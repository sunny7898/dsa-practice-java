package binary_search;

public class FindFirstAndLastOccurrenceInSorted {
    int lowerBound(int[] nums, int n, int target) {
        int low = 0;
        int high = n - 1;

        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    int upperBound(int[] nums, int n, int target) {
        int low = 0;
        int high = n - 1;

        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, n, target);
        if (lb == n || nums[lb] != target) return new int[]{-1, -1};
        return new int[]{lb, upperBound(nums, n, target) - 1};
    }
}
