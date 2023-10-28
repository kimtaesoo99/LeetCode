class Solution {
    private static final int MOD = 1000000007;

    public int countVowelPermutation(int n) {
        long[][] dp = new long[5][n + 1];
        for (int i = 0; i < 5; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1] + dp[4][i - 1]) % MOD;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
            dp[2][i] = (dp[1][i - 1] + dp[3][i - 1]) % MOD;
            dp[3][i] = (dp[2][i - 1]) % MOD;
            dp[4][i] = (dp[2][i - 1] + dp[3][i - 1]) % MOD;
        }
        return (int) ((dp[0][n] + dp[1][n] + dp[2][n] + dp[3][n] + dp[4][n]) % MOD);
    }
}
