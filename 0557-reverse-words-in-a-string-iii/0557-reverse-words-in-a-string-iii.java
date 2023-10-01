class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");

        StringBuilder result = new StringBuilder();
        StringBuilder now = new StringBuilder();

        for (String sp : split) {
            for (char c : sp.toCharArray()) {
                now.append(c);
            }
            result.append(now.reverse()).append(" ");
            now.setLength(0);
        }
        return result.substring(0,result.length() - 1);
    }
}