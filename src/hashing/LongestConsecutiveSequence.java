package hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if (n < 2) return n;

        // Brute force: O(N^2)
        /*
            Step 1: Iterate through the array
            Step 2: Take an element x and set its count to 1
            Step 3: Iterate the array for this element find x+1, x+2, each time increasing the count
            Step 4: Once inner loop completes, compare the count with the previous similar count to get the maxLen

        */

        // Better approach: O(NlogN)
        /*
            Arrays.sort(nums);

            int maxLen = 1;
            int currLen = 0;
            int lastSmaller = Integer.MIN_VALUE;

            for (int i = 0; i <n; i++) {
                if (nums[i] - 1 == lastSmaller) {
                    currLen++;
                    lastSmaller = nums[i];
                } else if (nums[i] != lastSmaller) {
                    lastSmaller = nums[i];
                    currLen = 1;
                }
                maxLen = Math.max(currLen, maxLen);
            }
            return maxLen;
        */

        // Optimal approach - O(N) - Hashing

        // Step 1: Put all elements in unordered set
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        int longestStreak = 0;
        for (int num: st) {

            // Step 1: Check if the current element is the first element of its sequence.
            /*
                For this, if there is an element 1 less then the current element in the map, it means the curr
                is not the first element
                Do nothing, ignore if the current element is not the first element of its sequence
            */

            // Step 2: Once the curr element is the start element of the sequence
            // Get the length of its sequence
            if (!st.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // if it is, count its streak
                while (st.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }

        return longestStreak;

    }
}
