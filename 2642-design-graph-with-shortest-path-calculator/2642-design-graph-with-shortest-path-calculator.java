import java.util.Arrays;

class Graph {
    private int[][] arr;

    public Graph(int n, int[][] edges) {
        arr = new int[n][n];
        Arrays.stream(arr).forEach(row -> Arrays.fill(row, 1000000000));
        for (int[] edge : edges) {
            arr[edge[0]][edge[1]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            arr[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Math.min(arr[i][j], arr[i][edge[0]] + arr[edge[1]][j] + edge[2]);
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        if (arr[node1][node2] == 1000000000) {
            return -1;
        }
        return arr[node1][node2];
    }
}