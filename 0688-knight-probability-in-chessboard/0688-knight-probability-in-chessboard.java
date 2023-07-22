public class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1;

        for (int moves = 1; moves <= k; moves++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int[] direction : directions) {
                        int preX = x - direction[0];
                        int preY = y - direction[1];
                        if (0 <= preX && preX < n && 0 <= preY && preY < n) {
                            dp[moves][x][y] += dp[moves - 1][preX][preY] / 8.0;
                        }
                    }
                }
            }
        }

        double answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += dp[k][i][j];
            }
        }
        return answer;
    }
}