import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> path = new HashMap<>();
        int n = stones.length;
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            path.put(stones[i], i);
        }

        dp[0][0] = true;

        for (int now = 0; now < n; now++) {
            for (int preJump = 0; preJump <= n; preJump++) {
                if (dp[now][preJump]) {
                    if (path.containsKey(stones[now] + preJump)) {
                        dp[path.get(stones[now] + preJump)][preJump] = true;
                    }
                    if (path.containsKey(stones[now] + preJump + 1)) {
                        dp[path.get(stones[now] + preJump + 1)][preJump + 1] = true;
                    }
                    if (path.containsKey(stones[now] + preJump - 1)) {
                        dp[path.get(stones[now] + preJump - 1)][preJump - 1] = true;
                    }
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (dp[n - 1][i]) {
                return true;
            }
        }
        return false;
    }
}