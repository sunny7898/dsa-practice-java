package dp.oneD;

public class HouseRobberII {

    /* Recursion */
    private int getMaxAmount(int[] nums, int first, int last) {

        if (last == first) return nums[last];
        if (last < first) return 0;

        int ifPicked = nums[last] + getMaxAmount(nums, first, last - 2);
        int ifNotPicked = 0 + getMaxAmount(nums, first, last - 1);

        return Math.max(ifPicked, ifNotPicked);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int withoutFirst = getMaxAmount(nums, 1, n - 1);
        int withoutLast = getMaxAmount(nums, 0, n - 2);
        return Math.max(withoutFirst, withoutLast);
    }
}
