package binary_search;

public class MinDaysToMakeMBouquets {
    private boolean isRequiredBouquetPossible(int[] bloomDay, int possibleMinDay, int k, int m) {
        int countBloomed = 0;
        int possibleBouquets = 0;
        for (int day: bloomDay) {
            if (day <= possibleMinDay) {
                countBloomed++;
            } else {
                possibleBouquets += countBloomed / k;
                countBloomed = 0;
            }
        }
        possibleBouquets += countBloomed / k;
        return possibleBouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int totalFlowers = bloomDay.length;
        long requiredFlowers = (long) m * k;

        // Case 1: Minimum number of flowers should atleast be the total flowers needed
        if (totalFlowers < requiredFlowers) return -1;

        int maxDay = Integer.MIN_VALUE;
        int minDay = Integer.MAX_VALUE;
        for (int day: bloomDay) {
            maxDay = Math.max(maxDay, day);
            minDay = Math.min(minDay, day);
        }

        int low = minDay, high = maxDay;
        while (low <= high) {
            int possibleMinDay = low + (high - low) / 2;

            if (isRequiredBouquetPossible(bloomDay, possibleMinDay, k, m)) {
                high = possibleMinDay - 1;
            }
            else {
                low = possibleMinDay + 1;
            }

        }
        return low;
    }
}
