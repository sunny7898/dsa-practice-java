package moore;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        /* Observation 1:
            At most, there can be max 2 elements which can be appearing more then n/3 times in the
            array.
        */

        // Brute force:
        /*
            Check the freq of each element TC - O(N^2) SC: O(1)
        */

        // Better approach
        /*
            1. Sort and check - TC: O(NlogN) SC: O(1)
            2. Hashing and check TC: O(N) SC: O(N)
        */


        // chatgpt approach - working for all
        int majorityElement1 = 0, majorityElement2 = 0;
        int votes1 = 0, votes2 = 0;

        for (int num : nums) {
            if (num == majorityElement1) {
                votes1++;
            } else if (num == majorityElement2) {
                votes2++;
            } else if (votes1 == 0  && num != majorityElement2) {
                majorityElement1 = num;
                votes1 = 1;
            } else if (votes2 == 0  && num != majorityElement1) {
                majorityElement2 = num;
                votes2 = 1;
            } else {
                votes1--;
                votes2--;
            }
        }

        // Second pass to verify counts
        votes1 = 0;
        votes2 = 0;

        for (int num : nums) {
            if (num == majorityElement1) {
                votes1++;
            } else if (num == majorityElement2) {
                votes2++;
            }
        }

        if (votes1 > n / 3) res.add(majorityElement1);
        if (votes2 > n / 3) res.add(majorityElement2);

        return res;
    }
}
