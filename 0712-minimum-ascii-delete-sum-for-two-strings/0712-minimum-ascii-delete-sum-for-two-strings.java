class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return minimumDeleteSum(s2, s1);
        }

        int[] row = new int[s2.length() + 1];

        for (int j = 1; j <= s2.length(); j++) {
            row[j] = row[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            int now = row[0];
            row[0] += s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                int answer;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    answer = now;
                } else {
                    answer = Math.min(s1.charAt(i - 1) + row[j], s2.charAt(j - 1) + row[j - 1]);
                }
                now = row[j];
                row[j] = answer;
            }
        }
        return row[s2.length()];
    }
}