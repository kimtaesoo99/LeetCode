import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        Queue<Integer> q = new LinkedList();
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            q.offer(arr[i]);
        }

        int now = arr[0];
        int win = 0;

        while (!q.isEmpty()) {
            int poll = q.poll();

            if (now > poll) {
                q.offer(poll);
                win++;
            } else {
                q.offer(now);
                now = poll;
                win = 1;
            }

            if (win == k || now == max) {
                return now;
            }
        }

        return -1;
    }
}
