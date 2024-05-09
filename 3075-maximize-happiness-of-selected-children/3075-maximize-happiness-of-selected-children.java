import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        int count = 0;
        for (int i = happiness.length - k; i < happiness.length; i++) {
            int now = happiness[i];
            int value = now - k + 1 + count++;

            if (value < 0) {
                value = 0;
            }
            sum += value;
        }
        
        return sum;
    }
}