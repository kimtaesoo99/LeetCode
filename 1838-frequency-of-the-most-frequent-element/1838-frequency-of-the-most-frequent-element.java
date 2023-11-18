import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int sum = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            int now = nums[right];
            sum += now;

            while ((right - left + 1) * now - sum > k) {
                sum -= nums[left];
                left++;
            }

            result = Math.max(result, (right - left + 1));
        }

        return result;
    }
}