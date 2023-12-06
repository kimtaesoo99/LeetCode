class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int monday = 1;
        
        while (n > 0) {
            for (int day = 0; day < Math.min(n, 7); day++) {
                result += monday + day;
            }
            
            n -= 7;
            monday++;
        }
        
        return result;
    }
}