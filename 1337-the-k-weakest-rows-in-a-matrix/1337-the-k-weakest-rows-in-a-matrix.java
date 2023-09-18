import java.util.Arrays;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr = new int[mat.length][2];

        for (int i = 0; i < mat.length; ++i) {
            int length = 0;
            for (int val : mat[i]) {
                length += val;
            }
            arr[i][0] = length;
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = arr[i][1];
        }

        return result;
    }
}