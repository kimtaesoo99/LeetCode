import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] network = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            network[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            network[from].add(to);
            network[to].add(from);
        }

        int maxRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = network[i].size() + network[j].size();
                if (network[i].contains(j) || network[j].contains(i)) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}