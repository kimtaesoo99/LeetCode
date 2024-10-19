class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sequence = new StringBuilder("0");

        for (int i = 1; i < n && k > sequence.length(); ++i) {
            sequence.append('1');

            for (int j = sequence.length() - 2; j >= 0; --j) {
                char invertedBit = (sequence.charAt(j) == '1') ? '0' : '1';
                sequence.append(invertedBit);
            }
        }

        return sequence.charAt(k - 1);
    }
}