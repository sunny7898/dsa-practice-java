package binary_search;

public class NthRootOfM {
    // return -1 if > m
    // return 0 if < m
    // return 1 if == m
    private int nthPowerOfM(int n, long mid, int m){
        long ans = 1;
        while (n > 0){
            if ((n & 1) == 1) {
                ans = ans * mid; // Use up one power out of total n power for mid (mid * mid * .... n times)
            }
            mid = mid * mid;
            n = n / 2;

            if (ans == m) return 1;
            if (ans > m) return -1;

        }

        return 0;
    }
    public int nthRoot(int n, int m) {

        int left = 1;
        int right = m;

        while (left <= right) {

            int mid = (left + right) / 2;

            int isNthPowerOfMidEqualsM = nthPowerOfM(n, mid, m);
            if (isNthPowerOfMidEqualsM == 1) return mid;

            if (isNthPowerOfMidEqualsM == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }
}
