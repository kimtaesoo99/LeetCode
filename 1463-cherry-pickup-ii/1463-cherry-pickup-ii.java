import java.util.Arrays;

class Solution {
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols][cols];

        for (int[][] mat : dp) {
            for (int[] arr : mat) {
                Arrays.fill(arr, -1);
            }
        }

        return helper(grid, 0, 0, cols - 1);
    }

    private int helper(int[][] grid, int row, int col1, int col2) {
        if (col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length) {
            return 0;
        }

        if (row == grid.length - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            } else {
                return grid[row][col1] + grid[row][col2];
            }
        }
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int ans;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx1 = col1 + i;
                int nx2 = col2 + j;

                if (col1 == col2) {
                    ans = grid[row][col1] + helper(grid, row + 1, nx1, nx2);
                } else {
                    ans = grid[row][col1] + grid[row][col2] + helper(grid, row + 1, nx1, nx2);
                }

                dp[row][col1][col2] = Math.max(ans, dp[row][col1][col2]);
            }
        }

        return dp[row][col1][col2];
    }
}
