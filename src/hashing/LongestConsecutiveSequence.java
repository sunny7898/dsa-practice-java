package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Brute force: O(N^2)
    /*
        Step 1: Iterate through the array
        Step 2: Take an element x and set its count to 1
        Step 3: Iterate the array for this element find x+1, x+2, each time increasing the count
        Step 4: Once inner loop completes, compare the count with the previous similar count to
        get the maxLen
    */
    private boolean searchNext(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public int longestConsecutiveBruteForce(int[] nums) {
        int maxLen = 0;
        for (int num : nums) {
            int curr = num;
            int currLen = 1;
            while (searchNext(nums, curr + 1)) {
                currLen++;
                curr = curr + 1;
            }
            maxLen = Math.max(currLen, maxLen);
        }
        return maxLen;
    }

    // Better approach: O(NlogN)
    /*
        Step 1: We will sort the array, and keep track of the previousSmaller element
        Step 2: for the current element,
            a. if the previousSmaller == curr - 1, => curr is a part of the seq
            hence increase the curr seq length & prevSmaller = curr
            b. if the prevSmaller != curr - 1 => curr is the new seq hence prevSmaller = curr,
            & curr seq len = 1
            c. if the prevSmaller != curr - 1 & prevSmaller == curr => continue
    */
    public int longestConsecutiveBetter(int[] nums) {

        Arrays.sort(nums);
        int prevSmaller = Integer.MIN_VALUE;
        int maxLen = 0;
        int currLen = 0;

        for (int curr : nums) {

            // Case: when the curr element is the part of the sequence
            if (prevSmaller == curr - 1) {
                currLen++;
                prevSmaller = curr;
            }
            // Case: when the curr element is equal to the prevSmaller element
            else if (prevSmaller == curr) {
                continue;
            }
            // Case: when the curr element is not the part of the curr sequence
            else if (prevSmaller != curr) {
                maxLen = Math.max(currLen, maxLen);
                currLen = 1;
                prevSmaller = curr;
            }

        }

        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }

    // Optimized Approach: TC: O(n) SC: O(n)
    /*
        Step 1: Put all the elements in the hashset
        Step 2: start iterating from 0th. for curr element
            a. if there exist a prev = curr - 1, then curr is not the start of the seq, moveon
            b. if there does not exist a prev -> this element is the start of the seq, hence
            now look for curr + 1, curr + 2 etc

    */
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int maxLen = 0;
        for (int curr : st) {

            // Case: When curr element is not the start of the sequence
            if (st.contains(curr - 1)) {
                continue;
            }
            // Case: When curr element is the start of the sequence
            else if (!st.contains(curr - 1)) {
                int currLen = 1;
                while (st.contains(curr + 1)) {
                    currLen++;
                    curr = curr + 1;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }
        return maxLen;
    }
}

/*

Brute force:
Lets say we take x, then we look for x+1, x+2, x+3 ....
TC: N^2

Better:
We will sort the array, and keep track of the previousSmaller element

for the current element,
a. if the previousSmaller == curr - 1, => curr is a part of the seq
hence increase the curr seq length & prevSmaller = curr
b. if the prevSmaller != curr - 1 => curr is the new seq hence prevSmaller = curr, & curr seq len = 1
c. if the prevSmaller != curr - 1 & prevSmaller == curr => continue

Optimized approach

It involves optimizing the brute force aproach of finding the next element in the seq
& optimizing the overall search mechanism

Put all the elements in the hashset
start iterating from 0th.
for curr element
-> if there exist a prev = curr - 1, then curr is not the start of the seq, moveon
-> if there does not exist a prev -> this element is the start of the seq, hence now look for
                                    curr + 1, curr + 2 etc


*/