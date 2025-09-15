package sorting;

import java.util.ArrayList;

public class MergeSort {
    void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> res = new ArrayList<>();

        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]){
                res.add(arr[i++]);
            } else {
                res.add(arr[j++]);
            }
        }

        while (i <= mid){
            res.add(arr[i++]);
        }
        while (j <= high){
            res.add(arr[j++]);
        }
        for (int k = low; k <= high; k++) {
            arr[k] = res.get(k - low);
        }
    }
    void mergeSort(int arr[], int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }


    private int[] merge2SortedArr(int[] arr1, int[] arr2){
        int m = arr1.length, n = arr2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            merged[k++] = (arr1[i] <= arr2[j]) ? arr1[i++] : arr2[j++];
        }
        while (i < m) merged[k++] = arr1[i++];
        while (j < n) merged[k++] = arr2[j++];

        return merged;
    }
    private int[] mergeSortHelper(int[] arr, int l, int r) {
        if (l == r) return new int[]{ arr[l] };

        int mid = l + (r - l) / 2;
        int[] left  = mergeSortHelper(arr, l, mid);
        int[] right = mergeSortHelper(arr, mid + 1, r);

        return merge2SortedArr(left, right);
    }
    void mergeSort2(int arr[], int l, int r) {
        if (arr == null || l > r) return;
        int[] sorted = mergeSortHelper(arr, l, r);
        System.arraycopy(sorted, 0, arr, l, sorted.length);
    }
}
