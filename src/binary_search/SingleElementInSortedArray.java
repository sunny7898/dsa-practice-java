package binary_search;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Boundary cases
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) return nums[mid];

            /*
                On left to the pivot - pattern is (even, odd)  - move right therefore eliminate left
                On right to the pivot - pattern is (odd, even) - move left therefore eliminate right
            */

            // if mid is on even index, check if at the next odd index, same element exist
            if ((mid & 1) == 0) {

                // if true means you are on left side of the pivot, eliminate left and move right
                if (nums[mid] == nums[mid + 1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            // if mid is on odd index, check if at the next even index, same element exist
            else if ((mid & 1) == 1) {

                // if true means you are on right side of the pivot, eliminate right and move left
                if (nums[mid] == nums[mid + 1])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
