import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);

        Arrays.sort(flowers, Arrays::compare);
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int now = 0;
        for (int p : sortedPeople) {
            while (now < flowers.length && flowers[now][0] <= p){
                pq.add(flowers[now][1]);
                now++;
            }
            
            while (!pq.isEmpty() && pq.peek() < p){
                pq.remove();
            }
            map.put(p, pq.size());
        }

        int[] result = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            result[i] = map.get(people[i]);
        }

        return result;
    }
}