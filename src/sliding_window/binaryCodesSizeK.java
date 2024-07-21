package sliding_window;

/*
    Problem: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */

import java.util.HashSet;
import java.util.Set;

public class binaryCodesSizeK {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();

        if(k > n) return false;

        Set<String> binaryCodes = new HashSet<>();

        for (int i = 0; i <= n - k; i++) {
            String substring = s.substring(i, i + k);
            binaryCodes.add(substring);
        }
        return binaryCodes.size() == (1 << k);
    }
}
