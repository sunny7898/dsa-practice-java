package kadane_algo;

import java.util.ArrayList;

public class PrintMaxSumSubarray {
    ArrayList<Integer> findSubarray(int n, int a[]) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        int start = -1;
        int end = -1;

        int currentStart = 0;

        for (int i = 0; i < n; i++) {

            if (currentSum == 0) currentStart = i;

            currentSum += a[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = currentStart;
                end = i;
            }

            if (currentSum < 0) currentSum = 0;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            res.add(a[i]);
        }
        return res;
    }
}
