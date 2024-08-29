import java.util.ArrayList;
import java.util.List;

class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (
                        stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]
                ) {
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }

        int numOfConnectedComponents = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(adjacencyList, visited, i);
                numOfConnectedComponents++;
            }
        }

        return n - numOfConnectedComponents;
    }

    private void depthFirstSearch(
            List<Integer>[] adjacencyList,
            boolean[] visited,
            int stone
    ) {
        visited[stone] = true;

        for (int neighbor : adjacencyList[stone]) {
            if (!visited[neighbor]) {
                depthFirstSearch(adjacencyList, visited, neighbor);
            }
        }
    }
}