import java.util.PriorityQueue;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        pq.add(new int[] {nums[0], 0});
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (i - pq.peek()[1] > k) {
                pq.remove();
            }

            int now = Math.max(0, pq.peek()[0]) + nums[i];
            result = Math.max(result, now);
            pq.add(new int[] {now, i});
        }

        return result;
    }
}