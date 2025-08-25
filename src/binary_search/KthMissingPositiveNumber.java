package binary_search;

public class KthMissingPositiveNumber {
    public int findKthPositiveBrute(int[] arr, int k) {
        int countMissing = 0;
        int n = arr.length;

        int i = 0;
        while (i < n) {
            // at each index count missing, and check if it gives us the range for k
            countMissing = arr[i] - (i + 1);
            if (countMissing >= k) {
                if (i == 0)
                    return k;
                i -= 1;
                break;
            }
            i++;
        }

        // i < n
        if (i < n) {
            countMissing = arr[i] - (i + 1);
            int rem = k - countMissing;
            return arr[i] + rem;
        }

        // i >= n
        if (i >= n) {
            int rem = k - countMissing;
            return arr[n - 1] + rem;
        }
        return -1;
    }

    public int findKthPositiveBruteBetter(int[] arr, int k) {
        int prev = 0;
        for (int num : arr) {
            int missing = num - prev - 1; // numbers missing between prev and num
            if (k <= missing) {
                return prev + k; // kth missing is in this gap
            }
            k = k - missing;
            prev = num;
        }
        return prev + k; // if not found inside, it’s after the last element
    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;

        // Binary search for first index where missing >= k
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1; // kth missing is to the right
            } else {
                right = mid - 1; // kth missing is to the left
            }
        }

        // After binary search, left = first index with missing >= k
        // kth missing = left + k
        return left + k;
    }
}
