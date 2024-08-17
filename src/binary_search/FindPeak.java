package binary_search;

public class FindPeak {
    public int findPeakElement(int[] nums) {

        int n = nums.length;
        if (n == 1) return 0;

        // check if 0th / n-1th index is the peak
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;

            // increasing slope pattern
            if (nums[mid - 1] < nums[mid]) low = mid + 1;
                // decreasing slope pattern
            else if (nums[mid - 1] > nums[mid]) high = mid - 1;
        }
        return -1;
    }
}
