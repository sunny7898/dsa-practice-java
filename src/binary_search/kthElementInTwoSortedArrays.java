package binary_search;

public class kthElementInTwoSortedArrays {
    public long kthElement(int k, int nums1[], int nums2[]) {
        int m = nums1.length;
        int n = nums2.length;
        // Ensure that nums1 is the smaller array to minimize the binary search space
        if (m > n) return kthElement(k, nums2, nums1);

        int total = m + n;
        int low = Math.max(0, k - n), high = Math.min(k, m); // Binary search bounds on the smaller array
        int elementsRequiredInLeft = k; // Total elements in the left half of the combined arrays

        while (low <= high) {
            int mid1 = low + ((high - low) >> 1); // Midpoint in the smaller array (nums1)
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
                return Math.max(l1, l2);
            }

            // If l1 > r2, move left in nums1 (reduce mid1)
            else if (l1 > r2) high = mid1 - 1;
                // If l2 > r1, move right in nums1 (increase mid1)
            else if (l2 > r1) low = mid1 + 1;
        }
        return 0;
    }
}
