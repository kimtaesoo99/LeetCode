class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid.length];

        for (int col = 0; col < grid.length; col++) {
            memo[grid.length - 1][col] = grid[grid.length - 1][col];
        }

        for (int row = grid.length - 2; row >= 0; row--) {
            for (int col = 0; col < grid.length; col++) {
                int nextMinimum = Integer.MAX_VALUE;
                for (int nextRowCol = 0; nextRowCol < grid.length; nextRowCol++) {
                    if (nextRowCol != col) {
                        nextMinimum = Math.min(nextMinimum, memo[row + 1][nextRowCol]);
                    }
                }

                memo[row][col] = grid[row][col] + nextMinimum;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < grid.length; col++) {
            answer = Math.min(answer, memo[0][col]);
        }

        return answer;
    }
}