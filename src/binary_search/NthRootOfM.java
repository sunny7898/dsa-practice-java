package binary_search;

public class NthRootOfM {
    // return -1 if > m
    // return 0 if < m
    // return 1 if == m
    int nthPowerOfM(int mid, int n, int m) {

        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;

            // preventing the overflow state
            if (ans > m) return -1;
        }

        if (ans == m) return 1;
        return 0;
    }

    public int NthRoot(int n, int m){

        int low = 1;
        int high = m;

        // Use binary search to iterate between 1 to m and eliminate the not needed
        // search space.
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int isNthPowerOfMidEqualsM= nthPowerOfM(mid, n, m);

            if (isNthPowerOfMidEqualsM == 1) return mid;

            if (isNthPowerOfMidEqualsM == -1)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
