import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
        }

        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{firstPerson, 0});
        
        while (!q.isEmpty()) {
            int[] personTime = q.poll();
            int person = personTime[0];
            int time = personTime[1];
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0];
                int nextPerson = nextPersonTime[1];
                if (t >= time && earliest[nextPerson] > t) {
                    earliest[nextPerson] = t;
                    q.offer(new int[]{nextPerson, t});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (earliest[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }
        return result;
    }
}
