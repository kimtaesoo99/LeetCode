import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private boolean[] visited;
    private List<String> results;

    public List<String> findItinerary(List<List<String>> tickets) {
        visited = new boolean[tickets.size()];
        results = new ArrayList<>();

        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                    int comparison = list1.get(i).compareTo(list2.get(i));
                    if (comparison != 0) {
                        return comparison;
                    }
                }
                return Integer.compare(list1.size(), list2.size());
            }
        });

        backTracking(tickets, "JFK", 0);

        return Arrays.stream(results.get(0).split(" ")).collect(Collectors.toList());
    }

    private void backTracking(List<List<String>> tickets, String now, int useTicketCount) {
        if (!results.isEmpty()){
            return;
        }
        if (useTicketCount == tickets.size()) {
            results.add(now);
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!visited[i] && now.substring(now.length() - 3).equals(tickets.get(i).get(0))) {
                visited[i] = true;
                backTracking(tickets, now + " " + tickets.get(i).get(1), useTicketCount + 1);
                visited[i] = false;
            }
        }
    }
}