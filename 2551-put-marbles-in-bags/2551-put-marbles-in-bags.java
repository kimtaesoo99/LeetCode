import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;

        int[] sumWeights = new int[n - 1];

        for (int i = 0; i < n - 1; ++i) {
            sumWeights[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(sumWeights, 0, n - 1);

        long answer = 0L;
        for (int i = 0; i < k - 1; ++i) {
            answer += sumWeights[n - 2 - i] - sumWeights[i];
        }

        return answer;
    }
}
