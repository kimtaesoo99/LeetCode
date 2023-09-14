import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> now = new LinkedList<>();
        now.add("JFK");
        LinkedList<String> result = new LinkedList<>();

        while (!now.isEmpty()) {
            while (!graph.getOrDefault(now.peekLast(), new PriorityQueue<>()).isEmpty()) {
                now.add(graph.get(now.peekLast()).poll());
            }
            result.addFirst(now.pollLast());
        }

        return result;
    }
}