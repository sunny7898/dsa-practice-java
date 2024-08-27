package partition;

public class RearrangeElementsBySignAlternate {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Optimized: when order is not preserved

        // Step 1: Partition the array in such a way that all +ve are on left and all -ve are on right
        int j = 0; // will track the first -ve
        int i = 0;
        while (i < n) {
            if (nums[i] > 0) {
                swap(nums, i, j);
                j++;
            }
            i++;
        }

        // Step 2: Swap the odd_index positive numbers with -ve numbers
        int left = 1, right = n/2 + 1;
        while (left <= right && right < n) {
            swap(nums, left, right);
            left+=2;
            right+=1;
        }
        return nums;

        // Optimized: when order is preserved
        // int[] ans = new int[n];

        // int posIdx = 0;
        // int negIdx = 1;

        // for (int i = 0; i < n; i++) {
        //     if (nums[i] > 0) {
        //         ans[posIdx] = nums[i];
        //         posIdx+=2;
        //     } else {
        //         ans[negIdx] = nums[i];
        //         negIdx+=2;
        //     }
        // }

        // return ans;
    }
}
