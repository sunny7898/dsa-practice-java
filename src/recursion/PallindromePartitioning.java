package recursion;
import java.util.List;
import java.util.ArrayList;

public class PallindromePartitioning {
    boolean isPallindrome(String substring) {

        int low = 0, high = substring.length() - 1;
        while (low <= high) {
            if (substring.charAt(low) != substring.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

    List<List<String>> getPartitions(String s, int n, int idx, ArrayList<String> current) {

        List<List<String>> res = new ArrayList<>();
        if (idx >= n) {
            res.add(new ArrayList<>(current));
            return res;
        }

        for (int i = idx; i < n; i++) {
            String substr = s.substring(idx, i + 1);
            if (isPallindrome(substr)) {
                current.add(substr);
                res.addAll(getPartitions(s, n, i + 1, current));
                current.remove(current.size() - 1);
            }
        }
        return res;
    }

    public List<List<String>> partition(String s) {
        return getPartitions(s, s.length(), 0, new ArrayList<String>());
    }

}
