class Solution {
    public int countHomogenous(String s) {
        int result = 0;
        int now = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                now++;
            } else {
                now = 1;
            }

            result = (result + now) % 1000000007;
        }

        return result;
    }
}