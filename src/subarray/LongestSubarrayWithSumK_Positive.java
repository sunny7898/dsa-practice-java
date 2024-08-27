package subarray;

public class LongestSubarrayWithSumK_Positive {

    public static int lenOfLongSubarr (int A[], int N, int K) {

        // Optimal for Array containing only positive - Variable size Sliding window TC - O(2N)

        int maxLength = 0;  // Variable to store the maximum length of subarray with sum equal to K
        long sum = A[0];  // Initialize the sum with the first element of the array

        int left = 0, right = 0;  // Initialize two pointers for the sliding window approach
        while (right < N) {  // Continue while the right pointer is within array bounds

            // Shrink the window from the left if the current sum exceeds K
            while (left <= right && sum > K) {
                sum -= A[left];  // Subtract the element at left pointer from the sum
                left++;  // Move the left pointer to the right
            }

            // If the current sum equals K, update the maximum length
            if (sum == K) {
                maxLength = Math.max(maxLength, right - left + 1);  // Calculate the length of the current subarray
            }

            right++;  // Move the right pointer to expand the window
            if (right < N) {
                sum += A[right];  // Add the element at the right pointer to the sum
            }
        }
        return maxLength;


        //  Optimal if array contains +ve, -ve and 0 - Hashing

        // int maxLen = 0;
        // long prefixSum = 0;
        // // Create a map to store the first occurrence of each prefix sum
        // Map<Long, Integer> mp = new HashMap<>();

        // // Traverse the prefix sum array
        // for (int i = 0; i < N; i++) {

        //     prefixSum += A[i];

        //     // If the prefix sum itself is equal to K, update maxLen
        //     if (prefixSum == K) maxLen = Math.max(maxLen, i + 1);

        //     // Check if there is a previous prefix sum such that
        //     // the difference is equal to K
        //     if (mp.containsKey(prefixSum - K)) {
        //         maxLen = Math.max(maxLen, i - mp.get(prefixSum - K));
        //     }

        //     // Only store the first occurrence to maximize the length of subarray
        //     /*
        //         this handles the case when we have gotten a prefixSum but it is then
        //         followed by 0s or -ve numbers.
        //         if we again store it, then later i - idxfromMap would be smaller
        //         therefore for a prefixSum, we would only keep the index
        //         of its first occurrence,

        //     */
        //     if (!mp.containsKey(prefixSum)) mp.put(prefixSum, i);
        // }

        // return maxLen;

    }
}
