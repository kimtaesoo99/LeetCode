class Solution {
    public int[][] transpose(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        
        int[][] result = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                result[c][r] = A[r][c];
            }
        return result;
    }
}