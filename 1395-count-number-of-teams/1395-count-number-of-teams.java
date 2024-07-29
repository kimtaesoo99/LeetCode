class Solution {
    public int numTeams(int[] rating) {
        int[] dp = new int[rating.length];
        int[] dp2 = new int[rating.length];
        
        for (int i = 1; i < rating.length; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    dp[i]++;
                }
                if (rating[i] < rating[j]) {
                    dp2[i]++;
                }
            }   
        }
        
        int sum = 0;
        for (int i = 2; i < rating.length; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    sum += dp[j];
                }
                if (rating[i] < rating[j]) {
                    sum += dp2[j];
                }
            }
        }
        
        return sum;
    }
}
