package binary_search;

public class KokoEatingBananas {
    private long getRequiredHoursForGivenSpeed(int[] piles, int speed, int maxHoursAllowed) {
        long totalHours = 0;
        for (int pile: piles) {
            totalHours += (pile + speed - 1) / speed;
            // totalHours += Math.ceil((double) pile / speed);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxSpeed = 0;
        for (int numBananas : piles) {
            maxSpeed = Math.max(maxSpeed, numBananas);
        }

        maxSpeed = Math.max(maxSpeed, h);

        int low = 1;
        int high = maxSpeed;
        // search space from 1 to maxSpeed
        while (low <= high) {

            // consider mid num of banana eating per hour as speed
            int mid = (low + high) / 2;
            long requiredHours = getRequiredHoursForGivenSpeed(piles, mid, h);

            if (requiredHours > h) {

                // increase the speed - move to right
                low = mid + 1;
            } else {

                // else try for smaller speed
            /*  no need to store
                since we will be moving from zone of not-possible to possible
                when high would reach to first non-possible element
                left would be at the answer
                1  2  3  4 5 6 7 8 9 10 11
                np np np p p p p p p  p  p
              minHourCount = Math.min(mid, minHourCount);
            */
                high = mid - 1;
            }
        }
        return low;
    }
}
