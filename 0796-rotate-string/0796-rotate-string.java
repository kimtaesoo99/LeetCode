class Solution {
    public boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            String now = s.substring(i, s.length()) + s.substring(0, i);
            if (now.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}
