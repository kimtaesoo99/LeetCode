class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= 65536; i++) {
            if (i * i > c) {
                break;
            }
            int m = c - i * i;

            double sqrt = Math.sqrt(m);
            
            if ((int) sqrt == sqrt) {
                return true;
            }
        }
        return false;
    }
}

