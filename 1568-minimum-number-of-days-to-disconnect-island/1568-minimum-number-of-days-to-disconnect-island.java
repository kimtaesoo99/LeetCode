class Solution {

    private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 },
    };

    public int minDays(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        ArticulationPointInfo apInfo = new ArticulationPointInfo(false, 0);
        int landCells = 0, islandCount = 0;

        int[][] discoveryTime = new int[rows][cols]; 
        int[][] lowestReachable = new int[rows][cols];
        int[][] parentCell = new int[rows][cols]; 

        for (int i = 0; i < rows; i++) {
            Arrays.fill(discoveryTime[i], -1);
            Arrays.fill(lowestReachable[i], -1);
            Arrays.fill(parentCell[i], -1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    landCells++;
                    if (discoveryTime[i][j] == -1) { 
                        
                        findArticulationPoints(
                            grid,
                            i,
                            j,
                            discoveryTime,
                            lowestReachable,
                            parentCell,
                            apInfo
                        );
                        islandCount++;
                    }
                }
            }
        }

        if (islandCount == 0 || islandCount >= 2) return 0; 
        if (landCells == 1) return 1; 
        if (apInfo.hasArticulationPoint) return 1;
        return 2; 
    }

    private void findArticulationPoints(
        int[][] grid,
        int row,
        int col,
        int[][] discoveryTime,
        int[][] lowestReachable,
        int[][] parentCell,
        ArticulationPointInfo apInfo
    ) {
        int rows = grid.length, cols = grid[0].length;
        discoveryTime[row][col] = apInfo.time;
        apInfo.time++;
        lowestReachable[row][col] = discoveryTime[row][col];
        int children = 0;

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidLandCell(grid, newRow, newCol)) {
                if (discoveryTime[newRow][newCol] == -1) {
                    children++;
                    parentCell[newRow][newCol] = row * cols + col; 
                    findArticulationPoints(
                        grid,
                        newRow,
                        newCol,
                        discoveryTime,
                        lowestReachable,
                        parentCell,
                        apInfo
                    );

                    lowestReachable[row][col] = Math.min(
                        lowestReachable[row][col],
                        lowestReachable[newRow][newCol]
                    );

                    if (
                        lowestReachable[newRow][newCol] >=
                            discoveryTime[row][col] &&
                        parentCell[row][col] != -1
                    ) {
                        apInfo.hasArticulationPoint = true;
                    }
                } else if (newRow * cols + newCol != parentCell[row][col]) {
                    lowestReachable[row][col] = Math.min(
                        lowestReachable[row][col],
                        discoveryTime[newRow][newCol]
                    );
                }
            }
        }

        if (parentCell[row][col] == -1 && children > 1) {
            apInfo.hasArticulationPoint = true;
        }
    }

    private boolean isValidLandCell(int[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        return (
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1
        );
    }

    private class ArticulationPointInfo {

        boolean hasArticulationPoint;
        int time;

        ArticulationPointInfo(boolean hasArticulationPoint, int time) {
            this.hasArticulationPoint = hasArticulationPoint;
            this.time = time;
        }
    }
}