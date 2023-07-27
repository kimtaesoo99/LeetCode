public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        long left = 1;
        long right = sum / n;

        while (left < right) {
            long target = right - (right - left) / 2;
            long extra = 0;

            for (int battery : batteries) {
                extra += Math.min(battery, target);
            }

            if (extra >= n * target) {
                left = target;
            } else {
                right = target - 1;
            }
        }
        return left;
    }
}