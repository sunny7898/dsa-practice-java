package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public int[][] merge(int[][] intervals) {

        int intervalsLength = intervals.length;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[] prev = intervals[0];

        for (int i = 1; i < intervalsLength; i++) {
            int[] current = intervals[i];

            if (current[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], current[1]);
            }
            else {
                res.add(prev);
                prev = current;
            };
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}
