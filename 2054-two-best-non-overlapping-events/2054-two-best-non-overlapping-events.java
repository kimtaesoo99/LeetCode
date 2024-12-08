class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int maxVal = 0, maxSum = 0;

        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek().getKey() < event[0]) {
                maxVal = Math.max(maxVal, pq.peek().getValue());
                pq.poll();
            }

            maxSum = Math.max(maxSum, maxVal + event[2]);
            pq.add(new Pair<>(event[1], event[2]));
        }

        return maxSum;
    }
}