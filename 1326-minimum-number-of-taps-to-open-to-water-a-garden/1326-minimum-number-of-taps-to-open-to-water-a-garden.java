import java.util.Arrays;

class Solution {
    public int minTaps(int n, int[] ranges) {
        int init = 100000;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, init);

        dp[0] = 0;

        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);

            for (int j = start; j <= end; j++) {
                dp[end] = Math.min(dp[end], dp[j] + 1);
            }
        }

        return dp[n] == init ? -1 : dp[n];
    }
}