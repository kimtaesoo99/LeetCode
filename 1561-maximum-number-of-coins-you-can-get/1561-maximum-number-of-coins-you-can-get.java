import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        ArrayDeque<Integer> dq = new ArrayDeque();
        for (int num : piles) {
            dq.addLast(num);
        }

        int result = 0;
        while (!dq.isEmpty()) {
            dq.removeLast(); 
            result += dq.removeLast(); 
            dq.removeFirst(); 
        }

        return result;
    }
}