package binary_search;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int totalWeight = 0;
        int maxWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
            maxWeight = Math.max(weight, maxWeight);
        }

        if(days == 1) return totalWeight;

        int low = maxWeight, high = totalWeight;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int numDays = 0;
            int weightSum = 0;
            for (int i = 0; i < n; i++) {
                weightSum += weights[i];
                if (weightSum > mid) {
                    numDays++;
                    weightSum = weights[i];
                }
            }
            numDays++;

            if (numDays > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
