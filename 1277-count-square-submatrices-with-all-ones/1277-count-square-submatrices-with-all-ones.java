class Solution {

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j + 1, grid, dp);
        int diagonal = solve(i + 1, j + 1, grid, dp);
        int below = solve(i + 1, j, grid, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }

    public int countSquares(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.fill(dp[i], -1);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += solve(i, j, grid, dp);
            }
        }

        return ans;
    }
}