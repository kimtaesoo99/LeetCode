import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(s -> s[0]));

        int result = 0;
        for (int i = 1; i < points.length; i++) {
            result = Math.max(result, points[i][0] - points[i - 1][0]);
        }

        return result;
    }
}
