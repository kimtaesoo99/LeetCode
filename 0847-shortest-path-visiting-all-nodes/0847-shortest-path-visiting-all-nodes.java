import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allVisited = (1 << n) - 1;
        Set<Integer> visited = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{1 << i, i, 0});
            visited.add((1 << i) * 16 + i);
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == allVisited) {
                return now[2];
            }

            for (int next : graph[now[1]]) {
                int mask = now[0] | (1 << next);
                int value = mask * 16 + next;

                if (!visited.contains(value)) {
                    visited.add(value);
                    q.offer(new int[]{mask, next, now[2] + 1});
                }
            }
        }

        return -1;
    }
}