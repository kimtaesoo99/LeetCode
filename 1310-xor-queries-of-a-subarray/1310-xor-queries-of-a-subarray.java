class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int xorSum = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                xorSum ^= arr[j];
            }
            result[i] = xorSum;
        }
        return result;
    }
}