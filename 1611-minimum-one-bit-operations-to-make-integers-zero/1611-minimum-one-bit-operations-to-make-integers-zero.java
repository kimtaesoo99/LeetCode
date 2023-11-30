class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        
        int k = 0;
        int now = 1;
        while (now * 2 <= n) {
            now *= 2;
            k++;
        }
        
        return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ now);
    }
}