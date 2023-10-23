public class Solution {
    public boolean isPowerOfFour(int n) {
        for (int i = 0; i <= 15; i++) {
            int powerOfFour = (int) Math.pow(4, i);
            if (powerOfFour == n) {
                return true;
            }
            if (powerOfFour > n) {
                return false;
            }
        }

        return false;
    }
}
