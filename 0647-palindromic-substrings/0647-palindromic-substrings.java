class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;

        if (n <= 0) {
            return 0;
        }

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i, ++result) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            result += (dp[i][i + 1] ? 1 : 0);
        }

        for (int len = 3; len <= n; ++len) {
            for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                result += (dp[i][j] ? 1 : 0);
            }
        }

        return result;
    }
}
