class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] first = new int[26];
        int[] second = new int[26];

        for (char ch : word1.toCharArray()) {
            first[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            second[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((first[i] == 0 && second[i] != 0) || (first[i] != 0 && second[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);

        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }
}