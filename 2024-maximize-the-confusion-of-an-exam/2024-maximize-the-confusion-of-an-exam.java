import java.util.HashMap;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int max = 0;
        int left = 0;
        
        for (int right = 0; right < answerKey.length(); right++) {
            char now = answerKey.charAt(right);
            count.put(now, count.getOrDefault(now, 0) + 1);

            while (Math.min(count.getOrDefault('T', 0), count.getOrDefault('F', 0)) > k) {
                count.put(answerKey.charAt(left), count.get(answerKey.charAt(left)) - 1);
                left++;
            }
            
            max = Math.max(max, right -left + 1);
        }

        return max;
    }
}