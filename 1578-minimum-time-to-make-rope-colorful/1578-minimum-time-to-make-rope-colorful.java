class Solution {
    public int minCost(String s, int[] neededTime) {
        int sum = 0;
        char now = s.charAt(0);
        int max = neededTime[0];

        for (int i = 1; i < neededTime.length; i++) {
            if (now == s.charAt(i)) {
                if (neededTime[i] > max) {
                    sum += max;
                    max = neededTime[i];
                } else {
                    sum += neededTime[i];
                }
            } else {
                now = s.charAt(i);
                max = neededTime[i];
            }
        }
        
        return sum;
    }
}