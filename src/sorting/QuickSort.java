package sorting;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = getPivotIdx(arr, low, high);
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }
    private int getPivotIdx(int[] arr, int low, int high) {
        int pivot = low;
        int i = low;
        int j = high;

        while (i < j){

            // from left to right, find the first ele > pivot_ele
            while (i <= high - 1 && arr[i] <= arr[pivot]) i++;

            // from right to left, find the first ele < pivot_ele
            while (j >= low + 1 && arr[j] > arr[pivot]) j--;

            if (i < j) swap(arr, i, j);
        }
        swap(arr, pivot, j);
        return j;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
