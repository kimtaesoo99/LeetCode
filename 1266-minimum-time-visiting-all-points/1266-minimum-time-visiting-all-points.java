class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int targetX = points[i + 1][0];
            int targetY = points[i + 1][1];
            result += Math.max(Math.abs(targetX - x), Math.abs(targetY - y));
        }

        return result;
    }
}