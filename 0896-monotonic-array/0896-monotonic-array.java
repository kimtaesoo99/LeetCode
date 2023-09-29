class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncrease = true;
        boolean isDecrease = true;

        int pre = nums[0];

        for (int num : nums) {
            if (num > pre){
                isDecrease = false;
            }
            if (num < pre) {
                isIncrease = false;
            }
            pre = num;
        }

        return isIncrease || isDecrease;
    }
}