import java.util.HashMap;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long gap = (long) nums[i] - nums[j];

                if (gap > Integer.MAX_VALUE || gap < Integer.MIN_VALUE) {
                    continue;
                }

                int d = (int) gap;

                dp[i].put(d, dp[i].getOrDefault(d, 0) + 1);
                if (dp[j].containsKey(d)) {
                    dp[i].put(d, dp[i].get(d) + dp[j].get(d));
                    count += dp[j].get(d);
                }
            }
        }

        return count;
    }
}