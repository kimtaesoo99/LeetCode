class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() / 2; i++) {
            sb.append(s.charAt(i));
            if (isRepeated(s, sb.toString())) {
                return true;
            }
        }
        return false;
    }

    private boolean isRepeated(String s, String now) {
        if (s.length() % now.length() != 0) {
            return false;
        }

        return s.equals(now.repeat(s.length() / now.length()));
    }
}