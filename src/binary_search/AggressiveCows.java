package binary_search;

import java.util.*;
import java.lang.*;

public class AggressiveCows {

    private static boolean canPlaceCows(int[] stalls, int N, int C, int mid) {
        int numCows = 0;
        int lastCowPosition = stalls[0];

        for (int i = 1; i < N; i++) {
            if (stalls[i] - lastCowPosition >= mid) {
                numCows++;
                lastCowPosition = stalls[i];
            }
            if (numCows >= C) return true;
        }
        return false;
    }
    private static int getMinimumLargestDistance(int[] stalls, int N, int C) {

        // Sorting was done, since the min distance between two stalls would be when they are consecutive
        Arrays.sort(stalls);
        //  int best = 0;
        int low = 1, high = stalls[N - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;

            // mid = possible min difference
            // if you can place all the cows in the mid-difference,
            // then try for increasing the mid (min diff in distance) between them
            if (canPlaceCows(stalls, N, C, mid)){
                // best = mid;
                low = mid + 1;
            }
            else {
               high = mid - 1;
            }

        }

        return high;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int C = sc.nextInt();
            int[] stalls = new int[N];
            for (int j = 0; j < N; j++) {
                stalls[j] = sc.nextInt();
            }

            int result = getMinimumLargestDistance(stalls, N, C);
            System.out.println(result);
        }
        sc.close();
    }
}
