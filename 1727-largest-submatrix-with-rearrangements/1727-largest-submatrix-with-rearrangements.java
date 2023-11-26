import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        for (int Y = 0; Y < m; Y++) {
            for (int x = 0; x < n; x++) {
                if (matrix[Y][x] != 0 && Y > 0) {
                    matrix[Y][x] += matrix[Y - 1][x];
                }
            }

            int[] now = matrix[Y].clone();
            Arrays.sort(now);
            for (int i = 0; i < n; i++) {
                result = Math.max(result, now[i] * (n - i));
            }
        }

        return result;
    }
}