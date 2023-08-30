class Solution {
    public long minimumReplacement(int[] nums) {
        long result = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }

            long division = (nums[i] + nums[i + 1] - 1) / nums[i + 1];

            result += division - 1;
            nums[i] = (int) (nums[i] / division);
        }
        
        return result;
    }
}