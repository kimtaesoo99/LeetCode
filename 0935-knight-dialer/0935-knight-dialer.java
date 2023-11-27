class Solution {
    
    private static int MOD = 1000000007;
    
    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        
        int A = 4;
        int B = 2;
        int C = 2;
        int D = 1;
        
        for (int i = 0; i < n - 1; i++) {
            int tempA = A;
            int tempB = B;
            int tempC = C;
            int tempD = D;
            
            A = ((2 * tempB) % MOD + (2 * tempC) % MOD) % MOD;
            B = tempA;
            C = (tempA + (2 * tempD) % MOD) % MOD;
            D = tempC;
        }
        
        int result = (A + B) % MOD;
        result = (result + C) % MOD;
        return (result + D) % MOD;
    }
}