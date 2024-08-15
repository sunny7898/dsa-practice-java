package merge_sort;

import java.util.ArrayList;

public class CountInversions {
    static long merge(long[] nums, int low, int mid, int high) {

        ArrayList<Long> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        long count = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                count += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        return count;
    }

    static long mergeSort(long[] nums, int low, int high) {
        long count = 0L;

        if (low >= high) return count;;

        int mid = (low + high) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }


    static long inversionCount(long nums[], int n) {
        return mergeSort(nums, 0, n-1);
    }
}
