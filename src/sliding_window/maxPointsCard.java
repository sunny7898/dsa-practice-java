package sliding_window;

/*
    Problem:
    https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 */

public class maxPointsCard {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Size of window (for which we have to minimize the sum)
        int windowSize = n - k;

        // Step 1: Find the sum of all the points
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
        }

        // Step 2: Find the sum of the points in the first window
        int minSum = 0;
        for (int i = 0; i < windowSize; i++) {
            minSum += cardPoints[i];
        }

        // This stores the sum of the prev points before the start of the current window
        int prevSum = 0;

        // This stores the sum of the new points added in the current window
        int nextSum = 0;

        // Slide the window starting from 1
        for (int j = 1; j <= n - windowSize; j++) {

            prevSum += cardPoints[j-1];
            nextSum += cardPoints[j + windowSize - 1];

            int currSum = minSum - prevSum + nextSum;
            if (currSum < minSum) {

                // We only need to store the sum of points
                // of index from minSum_window_start_idx - 1
                prevSum = 0;
                nextSum = 0;
                minSum = currSum;
            }
        }

        return totalSum - minSum;
    }
}
