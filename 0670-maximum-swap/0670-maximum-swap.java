class Solution {

    public int maximumSwap(int num) {
        String numStr = Integer.toString(num); 
        int n = numStr.length();
        int maxNum = num; 

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                char[] numeral = numStr.toCharArray(); 

                char temp = numeral[i];
                numeral[i] = numeral[j];
                numeral[j] = temp;

                int tempNum = Integer.parseInt(new String(numeral));
                maxNum = Math.max(maxNum, tempNum); 
            }
        }

        return maxNum; 
    }
}