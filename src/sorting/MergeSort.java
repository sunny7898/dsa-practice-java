package sorting;

import java.util.ArrayList;

public class MergeSort {
    void merge2SortedArrays(int[] arr, int low, int mid, int high) {

        // first arr = low to mid
        // second arr = mid + 1 to r

        int i = low;
        int j = mid + 1;
        ArrayList<Integer> merged = new ArrayList<>();

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                merged.add(arr[i]);
                i++;
            } else {
                merged.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            merged.add(arr[i]);
            i++;
        }
        while (j <= high) {
            merged.add(arr[j]);
            j++;
        }

        for (int k = low; k <= high; k++) {
            arr[k] = merged.get(k - low);
        }

    }
    void mergeSortHelper(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2 ;

        // divide arr into left part
        mergeSortHelper(arr, low, mid);
        // divide arr into right part
        mergeSortHelper(arr, mid + 1, high);
        // combine the result
        merge2SortedArrays(arr, low, mid, high);
    }

    void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }
}
