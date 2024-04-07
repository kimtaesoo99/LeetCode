class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return isValidString(0, 0, s, memo);
    }

    private boolean isValidString(int index, int openCount, String str, int[][] memo) {
        if (index == str.length()) {
            return (openCount == 0);
        }
        if (memo[index][openCount] != -1) {
            return memo[index][openCount] == 1;
        }
        boolean isValid = false;
        if (str.charAt(index) == '*') {
            isValid |= isValidString(index + 1, openCount + 1, str, memo); 
            if (openCount > 0) {
                isValid |= isValidString(index + 1, openCount - 1, str, memo);
            }
            isValid |= isValidString(index + 1, openCount, str, memo);
        } else {
            if (str.charAt(index) == '(') {
                isValid = isValidString(index + 1, openCount + 1, str, memo); 
            } else if (openCount > 0) {
                isValid = isValidString(index + 1, openCount - 1, str, memo); 
            }
        }

        memo[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }
}