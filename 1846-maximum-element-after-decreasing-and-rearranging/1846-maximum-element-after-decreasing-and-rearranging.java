import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int pre = 1;
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - pre);
            if (abs <= 1) {
                pre = arr[i];
                continue;
            }
            pre++;
        }

        return pre;
    }
}