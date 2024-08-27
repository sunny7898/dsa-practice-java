package array;

public class RemoveDuplicateFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        // Brute force:
        // ArrayList<Integer> res = new ArrayList<>();
        // int count = 1;
        // res.add(nums[0]);
        // for (int i = 1; i < n; i++) {
        //     count = (nums[i] == nums[i - 1]) ? count + 1 : 1;
        //     if (count <= 2) res.add(nums[i]);
        // }

        // for (int i = 0; i < res.size(); i++) nums[i] = res.get(i);
        // return res.size();

        // Optimized: Two pointer: Approach 1:
        // if (n <= 2) return n;

        // int i = 0;
        // int count = 1;
        // for (int j = 1; j < n; j++) {
        //     count = (nums[j] == nums[j - 1]) ? count + 1 : 1;
        //     if (count <= 2) nums[++i] = nums[j];
        // }
        // return i + 1;

        // Optimized - Two pointer: Approach 2:
        if (n <= 2) return n;

        int left = 2;
        for(int right = 2; right < n; right++) {
            if (nums[right] != nums[left - 2]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
