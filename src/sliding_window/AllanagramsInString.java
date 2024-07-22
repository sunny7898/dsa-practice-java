package sliding_window;

/*
    Problem:
    https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
    Refer:
    https://www.youtube.com/watch?v=fvEw13A5O1o
 */

import java.util.ArrayList;
import java.util.List;

public class AllanagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int left = 0, right = 0, remainingCharToCheck = p.length();
        while (right < s.length()) {

            // Decrement the count of the current character in the window
            char currentChar = s.charAt(right);
            if (pCount[currentChar - 'a'] > 0) {
                remainingCharToCheck--;
            }
            pCount[currentChar - 'a']--;
            right++;

            // Check if we have a valid window
            if (remainingCharToCheck == 0) {
                result.add(left);
            }

            // If the window size exceeds the length of p, move the left pointer
            if (right - left == p.length()) {
                char leftChar = s.charAt(left);
                // Restore the count of the character that is being excluded from the window
                if (pCount[leftChar - 'a'] >= 0) {
                    remainingCharToCheck++;
                }
                pCount[leftChar - 'a']++;
                left++;
            }
        }

        return result;
    }
}
