package binary_search;

public class SquareRootOfNumber {
    long floorSqrt(long n) {

        // long ans = 1;

        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = (left + right) / 2;

            long product = mid * mid;
            if (product > n) {
                // eliminate the right since there is no possibility of the answer at this side
                right = mid - 1;
            }
            // this can be an answer
            else if (product <= n) {
                /*
                    No need for this
                        ans = mid;
                    Because left is moving towards the answer in the answer possible area - towards right
                    and right is moving towards the answer eliminating the non - answer
                    possible area - towards left
                    at one point left would cross and would reach to first non-possible
                    area number while high would be at that time would be pointing to the answer
                */

                // eliminate the left side, since we are already taking the max number
                // on the left, hence eliminate the left side
                left = mid + 1;
            }
        }
        return right;
    }
}
