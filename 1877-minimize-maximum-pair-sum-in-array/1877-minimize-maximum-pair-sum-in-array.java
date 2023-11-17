import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i] + nums[n - i - 1]);
        }
        
        return max;
    }
}
