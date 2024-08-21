package binary_search;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Brute force: O(m + n) SC: O(n)
        /*
         * int m = nums1.length, n = nums2.length;
         * ArrayList<Integer> merged = new ArrayList<>(m + n);
         * int i = 0, j = 0;
         * while (i < m && j < n) {
         * if (nums1[i] <= nums2[j]) merged.add(nums1[i++]);
         * else merged.add(nums2[j++]);
         * }
         *
         * while (i < m) merged.add(nums1[i++]);
         * while (j < n) merged.add(nums2[j++]);
         *
         * int mergedSize = m + n;
         * if ((mergedSize & 1) == 1) return (double) merged.get(mergedSize / 2);
         * return (double) (merged.get(mergedSize / 2) + merged.get((mergedSize - 1) /
         * 2)) / 2.0;
         */

        // Better - we just need middle elements after merge - O(m + n) SC: O(1)
        /*
         *
         * int m = nums1.length, n = nums2.length;
         * int mergedSize = m + n;
         *
         * int i = 0, j = 0;
         *
         * int firstIdx = mergedSize / 2;
         * int secondIdx = (mergedSize - 1) / 2;
         * int count = 0;
         * int firstMiddle = -1, secondMiddle = -1;
         * while (i < m && j < n) {
         * if (nums1[i] <= nums2[j]) {
         * if (count == firstIdx) firstMiddle = nums1[i];
         * if (count == secondIdx) secondMiddle = nums1[i];
         * count++;
         * i++;
         * }
         * else {
         * if (count == firstIdx) firstMiddle = nums2[j];
         * if (count == secondIdx) secondMiddle = nums2[j];
         * count++;
         * j++;
         * }
         * }
         * while (i < m) {
         * if (count == firstIdx) firstMiddle = nums1[i];
         * if (count == secondIdx) secondMiddle = nums1[i];
         * count++;
         * i++;
         * }
         * while (j < n) {
         * if (count == firstIdx) firstMiddle = nums2[j];
         * if (count == secondIdx) secondMiddle = nums2[j];
         * count++;
         * j++;
         * }
         *
         * if ((mergedSize & 1) == 1) return (double) firstMiddle;
         * return (double) (firstMiddle + secondMiddle) / 2.0;
         */

        // Optimized approach: Binary search

        int m = nums1.length;
        int n = nums2.length;
        // Ensure that nums1 is the smaller array to minimize the binary search space
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int total = m + n;
        int low = 0, high = m; // Binary search bounds on the smaller array
        int elementsRequiredInLeft = (total + 1) / 2; // Total elements in the left half of the combined arrays
        while (low <= high) {
            int mid1 = (low + high) >> 1; // Midpoint in the smaller array (nums1)
            int mid2 = elementsRequiredInLeft - mid1; // Corresponding midpoint in the larger array (nums2)

            // Initially
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < m) r1 = nums1[mid1]; // Right part of nums1
            if (mid2 < n) r2 = nums2[mid2]; // Right part of nums2
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1]; // Left part of nums1
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1]; // Left part of nums2

            // Check if we have found the correct partition
            if (l1 <= r2 && l2 <= r1) {
                // If the total number of elements is odd, return the max of left halves
                if (total % 2 == 1) return Math.max(l1, l2);
                // If the total number of elements is even,
                // return the average of the max of left halves and min of right halves
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            // If l1 > r2, move left in nums1 (reduce mid1)
            else if (l1 > r2) high = mid1 - 1;
                // If l2 > r1, move right in nums1 (increase mid1)
            else if (l2 > r1) low = mid1 + 1;
        }
        return 0.0;
    }
}
