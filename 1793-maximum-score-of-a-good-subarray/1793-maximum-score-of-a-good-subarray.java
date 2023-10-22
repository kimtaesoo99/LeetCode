class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int result = nums[k];
        int now = nums[k];

        while (left > 0 || right < n - 1) {
            if ((left > 0 ? nums[left - 1] : 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                right++;
                now = Math.min(now, nums[right]);
            } else {
                left--;
                now = Math.min(now, nums[left]);
            }

            result = Math.max(result, now * (right - left + 1));
        }

        return result;
    }
}