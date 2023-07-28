class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return maxDiff(nums, 0, n - 1) >= 0;
    }

    private int maxDiff(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int leftScore = nums[left] - maxDiff(nums, left + 1, right);
        int rightScore = nums[right] - maxDiff(nums, left, right - 1);

        return Math.max(leftScore, rightScore);
    }
}