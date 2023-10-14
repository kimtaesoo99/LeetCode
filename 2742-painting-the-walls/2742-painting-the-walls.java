class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[n][i] = (int) 1e9;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int remain = 1; remain <= n; remain++) {
                int paint = cost[i] + dp[i + 1][Math.max(0, remain - 1 - time[i])];
                int noPaint = dp[i + 1][remain];
                dp[i][remain] = Math.min(paint, noPaint);
            }
        }

        return dp[0][n];
    }
}