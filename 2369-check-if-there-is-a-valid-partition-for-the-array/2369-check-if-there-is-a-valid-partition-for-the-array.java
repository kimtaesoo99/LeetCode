class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            int next = i + 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                dp[next] |= dp[next - 2];
            }
            if (i > 1 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                dp[next] |= dp[next - 3];
            }
            if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) {
                dp[next] |= dp[next - 3];
            }
        }

        return dp[n];
    }
}