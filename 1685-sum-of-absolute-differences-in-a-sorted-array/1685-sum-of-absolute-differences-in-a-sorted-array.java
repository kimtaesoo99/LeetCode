class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = pre[i] - nums[i];
            int rightSum = pre[n - 1] - pre[i];
            
            int leftCount = i;
            int rightCount = n - 1 - i;
            
            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];
            
            result[i] = leftTotal + rightTotal;
        }
        
        return result;
    }
}