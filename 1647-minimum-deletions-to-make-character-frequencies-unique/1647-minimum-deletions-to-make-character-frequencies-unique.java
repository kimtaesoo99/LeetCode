import java.util.Arrays;

public class Solution {
    public int minDeletions(String s) {
        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        Arrays.sort(frequency);

        int count = 0;

        for (int i = 24; i >= 0; i--) {
            if (frequency[i] == 0) {
                break;
            }

            if (frequency[i] >= frequency[i + 1]) {
                int prev = frequency[i];
                frequency[i] = Math.max(0, frequency[i + 1] - 1);
                count += prev - frequency[i];
            }
        }

        return count;
    }
}
