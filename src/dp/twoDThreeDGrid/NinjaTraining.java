package dp.twoDThreeDGrid;

public class NinjaTraining {

    /* Recursion */
    private int getMaxPoints(int[][] tasks, int day, int lastTask) {
        int maxPoints = 0;

        if (day == 0) {
            for (int i = 0; i <= 2; i++) {
                if (i != lastTask) {
                    maxPoints = Math.max(maxPoints, tasks[0][i]);
                }
            }
            return maxPoints;
        }

        int points = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != lastTask) {
                points = tasks[day][i] + getMaxPoints(tasks, day - 1, i);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return maxPoints;
    }

    public int maximumPoints(int[][] arr, int N) {
        return getMaxPoints(arr, N - 1, N);
    }

    /* Memoization */
    private int getMaxPoints(int[][] points, int day, int lastTask, int[][] dp) {

        int maxPoint = 0;

        // Base case: If it's the first day, pick the best task that isn't the lastTask
        if (day == 0) {
            for (int task = 0; task <= 2; task++) {
                if (task != lastTask) {
                    maxPoint = Math.max(maxPoint, points[0][task]);
                }
            }
            return maxPoint;
        }

        // If already computed, return stored result
        if (dp[day][lastTask] != -1) return dp[day][lastTask];

        int point = 0;
        // Try all tasks for the current day, except the last performed task
        for (int i = 0; i <= 2; i++) {
            if (i != lastTask) {
                point = points[day][i] + getMaxPoints(points, day - 1, i, dp);
                maxPoint = Math.max(maxPoint, point);
            }
        }

        return dp[day][lastTask] = maxPoint; // Memoize result
    }

    public int maximumPointsMemoization(int[][] arr, int N) {
        int[][] dp = new int[N][4]; // Create DP table with size [N][4] (tasks 0, 1, 2, and lastTask 3)

        // Initialize the dp table with -1 (indicating uncomputed states)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) dp[i][j] = -1;
        }

        // Start from the last day with no last task done (represented by task 3)
        return getMaxPoints(arr, N - 1, 3, dp);
    }

    /* Tabulation */
    public int maximumPointsTabulation(int[][] points, int n) {
        int[][] dp = new int[n][4]; // Create DP table with size [N][4] (tasks 0, 1, 2, and lastTask 3)

        // Base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    /* Tabulation Optimized */
    public int maximumPointsTabulationOptimized(int[][] points, int n) {
        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            // for current day - day
            int[] today = new int[4];
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        today[last] = Math.max(today[last], point);
                    }
                }
            }

            // once points for all tasks choice completed
            prev = today;
        }
        return prev[3];
    }
}
