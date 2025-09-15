package sorting;

import java.util.Arrays;

public class Merge2SortedArrayWithoutExtraSpace {
    public void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] merged = new int[m + n];
        int idx = 0;
        while (i < m && j < n) {
            merged[idx++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < m) merged[idx++] = nums1[i++];
        while (j < n) merged[idx++] = nums2[j++];

        for (int k = 0; k < m + n; k++) {
            if (k < m) nums1[k] = merged[k];
            else nums2[k - m] = merged[k];
        }
    }

    // TC: IF (m < n) - O(m) + mlogm + nlogn
    public void mergeOptimal1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n){
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
    // Based on Gap method: Shell sort: TC: O((m+n) log(m+n))
    private void swapIfGreater(int[] nums1, int[] nums2, int idx1, int idx2) {
        if (nums1[idx1] > nums2[idx2]) {
            int temp = nums1[idx1];
            nums1[idx1] = nums2[idx2];
            nums2[idx2] = temp;
        }
    }
    public void mergeOptimal2(int[] nums1, int m, int[] nums2, int n) {
        int len = (n + m) / 2;
        int gap = len / 2 + (len % 2); // shortcut to ceil

        while (gap > 0){
            int left = 0;
            int right = left + gap;

            // till right crosses the boundary
            while (right < len){
                // 3 types of positioning for left and right

                // Case 1: when left lies in first arr, and right lies in second arr
                if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                    // Case 2: When both pointers lie in second array
                } else if (left >= n){
                    swapIfGreater(nums2, nums2, left - m, right - m);
                    // Case 3: When both lies in the first array
                } else {
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = gap / 2 + (gap % 2);
        }
    }
}
