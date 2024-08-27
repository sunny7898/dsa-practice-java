package array;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        // // Brute force: TC: O(n) SC: O(n)
//        Set<Integer> unique = new LinkedHashSet<>();
//        for (int num: nums) {
//            unique.add(num);
//        }
//        int i = 0;
//        for (int num: unique){
//            nums[i++] = num;
//        }
//        return unique.size();

        // Optimized - Two pointer - TC: O(n)
        int i = 0, j = 1;
        while (j < n) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return (i + 1);
    }
}
