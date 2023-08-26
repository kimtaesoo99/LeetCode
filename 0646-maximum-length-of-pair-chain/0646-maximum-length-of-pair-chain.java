import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int findLongestChain(int[][] pairs) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int[] pair : pairs) {
            pq.add(new Node(pair[0], pair[1]));
        }

        List<Integer> list = new ArrayList<>();

        list.add(pq.poll().end);

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (list.get(list.size() - 1) < now.start) {
                list.add(now.end);
            }
        }
        return list.size();
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        if (o.end == this.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}