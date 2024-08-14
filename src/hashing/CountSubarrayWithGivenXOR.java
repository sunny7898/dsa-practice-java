package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithGivenXOR {
    public int solve(ArrayList<Integer> nums, int B) {

        int n = nums.size();
        int count = 0;
        int prefixXOR = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n;  i++) {

            prefixXOR ^= nums.get(i);

            if (prefixXOR == B) {
                count++;
            }

            if (mp.containsKey(prefixXOR ^ B)) {
                count += mp.get(prefixXOR ^ B);
            }

            mp.put(prefixXOR, mp.getOrDefault(prefixXOR, 0) + 1);
        }

        return count;
    }
}
