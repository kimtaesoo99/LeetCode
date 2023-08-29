class Solution {
    public int bestClosingTime(String customers) {
        int remainY = 0;

        for (char customer : customers.toCharArray()) {
            if (customer == 'Y') {
                remainY++;
            }
        }
        
        int passN = 0;
        int minIndex = 0;
        int minPenalty = remainY;

        for (int i = 0; i < customers.length(); i++) {
            char now = customers.charAt(i);
            if (now == 'Y') {
                remainY--;
            } else {
                passN++;
            }
            if (passN + remainY < minPenalty) {
                minIndex = i + 1;
                minPenalty = passN + remainY;
            }
        }
        return minIndex;
    }
}