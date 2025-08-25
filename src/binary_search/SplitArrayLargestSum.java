package binary_search;

public class SplitArrayLargestSum {
    private boolean requiredSplitPossibleForMidSum(int[] nums, int mid, int k){
        int sum = 0;
        int count = 1;
        for (int num: nums){
            sum += num;
            if (sum > mid){
                count++;
                sum = num;
            }
        }
        if (count <= k) return true;
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        for (int num: nums) {
            left = Math.max(left, num);
            right += num;
        }
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (requiredSplitPossibleForMidSum(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
