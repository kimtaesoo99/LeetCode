class Solution {

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            return result;
        }
        for (int i = 0; i < result.length; i++) {
            if (k > 0) {
                for (int j = i + 1; j < i + k + 1; j++) {
                    result[i] += code[j % code.length];
                }
            } else {
                for (int j = i - Math.abs(k); j < i; j++) {
                    result[i] += code[(j + code.length) % code.length];
                }
            }
        }
        return result;
    }
}