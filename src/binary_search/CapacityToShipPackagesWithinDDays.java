package binary_search;

public class CapacityToShipPackagesWithinDDays {
    private boolean checkForMidWtCapacity(int[] weights, int capacity, int days){
        int wtCarry = 0;
        int numDays = 0;
        for (int weight: weights) {
            wtCarry += weight;
            if (wtCarry > capacity) {
                wtCarry = weight;
                numDays++;
            }
        }
        if (wtCarry <= capacity) numDays++;
        return numDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int ans = -1;

        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int weight : weights){
            start = Math.max(start, weight);
            end += weight;
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (checkForMidWtCapacity(weights, mid, days)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
