package binary_search;

public class FindMinInSortedRotatedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = 5001;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if the remaining search space is already sorted, no need to perform binary search further
            if (nums[low] <= nums[high]) {
                ans = Math.min(nums[low], ans);
                break;
            }

            if (nums[low] <= nums[mid]) {
                // pick the smallest element from the sorted part
                ans = Math.min(ans, nums[low]);
                // and eliminate the sorted part
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
