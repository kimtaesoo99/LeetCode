class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveOdds = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                consecutiveOdds++;
            } else {
                consecutiveOdds = 0;
            }

            if (consecutiveOdds == 3) {
                return true;
            }
        }

        return false;
    }
}