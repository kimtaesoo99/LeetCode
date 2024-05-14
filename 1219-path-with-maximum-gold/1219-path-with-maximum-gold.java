class Solution {
    private final int[] DIRECTIONS = new int[] { 0, 1, 0, -1, 0 };

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                maxGold = Math.max(maxGold, dfsBacktrack(grid, rows, cols, row, col));
            }
        }
        return maxGold;
    }

    private int dfsBacktrack(int[][] grid, int rows, int cols, int row, int col) {
        if (row < 0 || col < 0 || row == rows || col == cols || grid[row][col] == 0) {
            return 0;
        }
        int maxGold = 0;

        int originalVal = grid[row][col];
        grid[row][col] = 0;

        for (int direction = 0; direction < 4; direction++) {
            maxGold = Math.max(maxGold,
                    dfsBacktrack(grid, rows, cols, DIRECTIONS[direction] + row,
                                 DIRECTIONS[direction + 1] + col));
        }

        grid[row][col] = originalVal;
        return maxGold + originalVal;
    }
}