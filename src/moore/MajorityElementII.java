package moore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MajorityElementII {
    /*
        Observation:
        In a n sized array, for the given condition, elements with freq > floor of n/3.
        There could be max atmost 2 elements that fulfills this condition in the array

        Example:
        2,2,2,3,3,1,1,1 n = 8

        floor of : n / 3 = 8 / 3 = 2
        So for the condition, an element would have to occuring atleast 3 times.

        1st ele = 3
        2nd ele = 3
        remaining = 2 <---- therefore at max 2 elements with more then n/3 freq

        Use of this:
        In the brute force,
        We would count the freq for each element, by iterating the complete array
        - this can be optimized by
        taking a 2 size array to keep track of the req elements, and use
        them to ignore the repeatitive elements also as soon as the count is 2, we can
        stop
    */
    public List<Integer> majorityElementBrute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            // Skip if already added
            if (result.contains(current)) continue;

            int count = 0;
            for (int num : nums) {
                if (num == current) {
                    count++;
                }
            }

            if (count > threshold) {
                result.add(current);
            }

            // At most 2 majority elements possible when threshold is n/3
            if (result.size() == 2) break;
        }
        return result;
    }

    /*
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
            if (mp.getValue(num) > threshold) result.add(mp.getKey(num));


        <---- mp.getValue() or getKey() does not exist in map
        <---- to get the value use below logic
        }

    */
    public List<Integer> majorityElementBetter(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int num: nums){
            int count = mp.getOrDefault(num, 0) + 1;
            mp.put(num, count);
            if (count > threshold && !result.contains(num)) {
                result.add(num);
            }
            if (result.size() == 2) break;
        }

        return result;
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int votes1 = 0, votes2 = 0;
        int majorityElement1 = Integer.MIN_VALUE, majorityElement2 = Integer.MIN_VALUE;
        for(int num: nums) {

            // 3 Step approach:

            // Step 1: Initialize the majorityelements
            if (votes1 == 0 && num != majorityElement2) {
                votes1 = 1;
                majorityElement1 = num;
            } else if (votes2 == 0 && num != majorityElement1) {
                votes2 = 1;
                majorityElement2 = num;

                // Step 2: If any majorityElement is found, increase the count of that
            } else if (majorityElement1 == num) {
                votes1++;
            } else if (majorityElement2 == num) {
                votes2++;

                // Step 3: If the majorityElement is not found, decrease the count
            } else {
                votes1--;
                votes2--;
            }
        }

        // Second pass to verify counts. Ex: {1, 2, 3, 4, 5, 6};
        votes1 = 0;
        votes2 = 0;

        for (int num : nums) {
            if (num == majorityElement1) {
                votes1++;
            } else if (num == majorityElement2) {
                votes2++;
            }
        }

        int threshold = nums.length / 3;
        if (votes1 > threshold) result.add(majorityElement1);
        if (votes2 > threshold) result.add(majorityElement2);

        return result;

    }
}
