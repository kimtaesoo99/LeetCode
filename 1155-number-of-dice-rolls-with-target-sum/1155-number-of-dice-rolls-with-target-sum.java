class Solution {
    
    int mod = 1000000007; 
    
    public int numRollsToTarget(int n, int k, int target) {
        int [][]dp = new int[n+1][target+1];
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return helper(n,k,target,dp);
    }
    
    public int helper(int n, int k, int target,int[][]dp){
        if(n == 0 && target == 0 ) {
            return 1;
        }
        if(n == 0 || target <= 0 ) {
            return 0;
        }
        if(dp[n][target]!=-1) {
            return dp[n][target] % mod;
        }
        
        dp[n][target] = 0;
        
        for(int i = 1;i<=k;i++){
            dp[n][target] = (dp[n][target]+helper(n-1,k,target-i,dp))%mod;
        }
        
        return dp[n][target];
    }
}