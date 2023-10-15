class Solution {
    private static final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        int[] dp = new int[arrLen];
        int[] pre = new int[arrLen];
        pre[0] = 1;

        for (int remain = 1; remain <= steps; remain++) {
            dp = new int[arrLen];

            for (int now = arrLen - 1; now >= 0; now--) {
                int result = pre[now];
                if (now > 0) {
                    result = (result + pre[now - 1]) % MOD;
                }

                if (now < arrLen - 1) {
                    result = (result + pre[now + 1]) % MOD;
                }

                dp[now] = result;
            }

            pre = dp;
        }

        return dp[0];
    }
}
