class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int result = -1;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left + 1; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    result = Math.max(result, right - left - 1);
                }
            }
        }
        
        return result;
    }
}