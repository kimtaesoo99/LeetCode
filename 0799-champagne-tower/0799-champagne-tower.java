class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                double division = (tower[i][j] - 1) / 2.0;
                if (division > 0){
                    tower[i + 1][j] += division;
                    tower[i + 1][j + 1] += division;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}