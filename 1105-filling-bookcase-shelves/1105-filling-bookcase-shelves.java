class Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];

        dp[0] = 0;
        dp[1] = books[0][1];

        for (int i = 2; i <= books.length; i++) {
            int remainingShelfWidth = shelfWidth - books[i - 1][0];
            int maxHeight = books[i - 1][1];
            dp[i] = books[i - 1][1] + dp[i - 1];

            int j = i - 1;
            while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                remainingShelfWidth -= books[j - 1][0];
                dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
                j--;
            }
        }

        return dp[books.length];
    }
}