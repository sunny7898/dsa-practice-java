package binary_search;

public class MinimizeMaxDistanceToGasStations {
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    private static int numberOfGasStationsRequired(int[] stations, int n, double dist) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((stations[i] - stations[i-1]) / dist);
            if ((stations[i] - stations[i-1]) == (numberInBetween * dist)) {
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }
    public static double findSmallestMaxDist(int stations[], int k) {

        // Better: Priority queue approach
        // Time Complexity: O(nlogn + klogn),  n = size of the given array, k = no. of gas stations to be placed.
        // Reason: Insert operation of priority queue takes logn time complexity. O(nlogn) for inserting all the indices with distance values and O(klogn) for placing the gas stations.

        // Space Complexity: O(n-1)+O(n-1)
        // Reason: The first O(n-1) is for the array to keep track of placed gas stations and the second one is for the priority queue.

        /*
        int n = stations.length;
        int numOfSections = n - 1;
        int[] sections = new int[numOfSections];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            int firstComparison = Double.compare(b.first, a.first);
            if (firstComparison == 0) {
                return Integer.compare(b.second, a.second);
            }
            return firstComparison;
        });

        // Inserting all the sections in priority queue
        // insert the first n-1 elements into pq
        // with respective distance values:
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(stations[i + 1] - stations[i], i));
        }

        // O(K* logN)
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            Pair tp = pq.poll();
            int maxSectionLenIdx = tp.second;
            sections[maxSectionLenIdx]++;

            double initialDiff = stations[maxSectionLenIdx + 1] - stations[maxSectionLenIdx];
            double newSectionLen = initialDiff / (double) (sections[maxSectionLenIdx] + 1);
            pq.add(new Pair(newSectionLen, maxSectionLenIdx));

        }

        return Math.round(pq.peek().first * 100.0) / 100.0;
        */


        // Brute force approach: TLE
        /*
        int n = stations.length;
        int numOfSections = n - 1;
        int[] sections = new int[numOfSections];

        // O(K* N)
        for (int i = 1; i <= k; i++) {

            double maxSectionLength = -1;
            int maxSectionLengthIdx = -1;
            for (int j = 0; j < n - 1; j++) {

                double diff = (stations[j + 1] - stations[j]);
                double sectionLength = (double) diff / (double) (sections[j] + 1);
                if (sectionLength > maxSectionLength) {
                    maxSectionLength = sectionLength;
                    maxSectionLengthIdx = j;
                }
            }

            sections[maxSectionLengthIdx]++;
        }

        double maxAns = 0.0;
        for (int i = 0; i < n - 1; i++) {
            double diff = stations[i + 1] - stations[i];
            double sectionLength = (double) diff / (double) (sections[i] + 1);
            maxAns = Math.max(sectionLength, maxAns);
        }
        return Math.round(maxAns * 100.0) / 100.0;
        */

        // Optimized approach: Binary search - reducing space complexity
        /*
            The issue here is that we have distance in double to compare while
            in past we had only been using the integer for positional comparison.

            Hence, we will change the original binary search signature
        */

        int n = stations.length;

        double low = 0;
        double high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double) (stations[i + 1] - stations[i]));
        }

        double diff = 1e-2;

        while (high - low > diff){
            double mid = (low + high) / 2.0;
            int count = numberOfGasStationsRequired(stations, n, mid);

            // the distance is too low
            if (count > k){
                low = mid;
                // minimize the distance
            } else {
                high = mid;
            }
        }
        return high;

    }
}
