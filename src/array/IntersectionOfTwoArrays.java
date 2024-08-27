package array;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {

            if (nums1[i] == nums2[j] ) {
                if (res.isEmpty() || nums1[i] != res.get(res.size() - 1)) res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] ans = new int[res.size()];
        for (int k = 0; k < res.size(); k++){
            ans[k] = res.get(k);
        }

        return ans;
    }
}
