package dp_knapsack;

import java.util.Arrays;
import java.util.List;

public class MinimizeCostForGivenMinWeight {

    public static long getMinimumCost(List<Integer> cost, int minWeight) {
        int n = cost.size();
        int maxWeight = 1 << n; // max possible weight is 2^n - 1
        long[] minCost = new long[maxWeight + 1];
        Arrays.fill(minCost, Long.MAX_VALUE);
        minCost[0] = 0; // No cost to achieve weight 0

        // Traverse through all possible weights
        for (int weight = 0; weight <= maxWeight; weight++) {
            if (minCost[weight] == Long.MAX_VALUE) continue;
            for (int i = 0; i < n; i++) {
                int newWeight = weight + (1 << i); // Adding the weight of the i-th item
                if (newWeight <= maxWeight) {
                    minCost[newWeight] = Math.min(minCost[newWeight], minCost[weight] + cost.get(i));
                }
            }
        }

        long answer = Long.MAX_VALUE;
        for (int weight = minWeight; weight <= maxWeight; weight++) {
            answer = Math.min(answer, minCost[weight]);
        }

        // Debugging: print the minCost array and final answer
        System.out.println("minCost array: " + Arrays.toString(minCost));
        System.out.println("Final answer: " + answer);

        return answer;
    }

    public static void main(String[] args) {
        List<Integer> cost = Arrays.asList(10, 9, 9, 10); // Example costs
        int minWeight = 14; // Example minimum weight
        System.out.println(getMinimumCost(cost, minWeight)); // Output result
    }
}
