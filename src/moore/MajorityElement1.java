package moore;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {
    public int majorityElementWithMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        int majorityElement = nums[0];
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> e: freqMap.entrySet()){
            if (e.getValue() > maxCount){
                majorityElement = e.getKey();
                maxCount = e.getValue();
            }
        }

        return majorityElement;
    }
    public int majorityElement(int[] arr) {
        int n = arr.length;

        int majorityElement = arr[0];
        int votes = 1;

        for (int i = 1; i < n; i++) {
            votes = (arr[i] == majorityElement) ? votes + 1 : votes - 1;

            if (votes == 0) {
                majorityElement = arr[i];
                votes = 1;
            }
        }

        // Note: since the question mentioned that there will be a majority element, hence we skipped the
        // post-validation for the found majority element, otherwise that is a must step.
        // because even if there is no majority element, the votes can still end +ve.

        return majorityElement;
    }
}
