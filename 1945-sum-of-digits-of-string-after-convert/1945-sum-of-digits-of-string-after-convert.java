class Solution {

    public int getLucky(String s, int k) {

        String numericString = "";
        for (char ch : s.toCharArray()) {
            numericString += Integer.toString(ch - 'a' + 1);
        }

        while (k-- > 0) {
            int digitSum = 0;
            for (char digit : numericString.toCharArray()) {
                digitSum += digit - '0';
            }
            numericString = Integer.toString(digitSum);
        }

        return Integer.parseInt(numericString);
    }
}