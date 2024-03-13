public class Solution {
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int j = 1; j <= i; j++) {
                sumLeft += j;
            }

            for (int k = i; k <= n; k++) {
                sumRight += k;
            }

            if (sumLeft == sumRight) {
                return i; 
            }
        }

        return -1;
    }
}