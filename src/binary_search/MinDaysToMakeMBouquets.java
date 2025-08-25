package binary_search;

public class MinDaysToMakeMBouquets {
    private boolean canMakeMBouquets(int[] bloomDay, int m, int k, int days) {
        int count = 0, bouquets = 0;
        for (int day : bloomDay) {
            if (day <= days) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        int n = bloomDay.length;
        long totalFlowerNeeded = (long) m * k;
        if (totalFlowerNeeded > n)
            return -1;

        int start = Integer.MAX_VALUE; // min
        int end = Integer.MIN_VALUE; // max
        for (int day : bloomDay) {
            start = Math.min(day, start);
            end = Math.max(day, end);
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (canMakeMBouquets(bloomDay, m, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
