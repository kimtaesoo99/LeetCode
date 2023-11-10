import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap();

        for (int[] pair : adjacentPairs) {
            int x = pair[0];
            int y = pair[1];

            if (!map.containsKey(x)) {
                map.put(x, new ArrayList());
            }

            if (!map.containsKey(y)) {
                map.put(y, new ArrayList());
            }

            map.get(x).add(y);
            map.get(y).add(x);
        }

        int root = 0;
        for (int num : map.keySet()) {
            if (map.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int now = root;
        int[] result = new int[map.size()];
        result[0] = root;
        int i = 1;
        int pre = Integer.MAX_VALUE;

        while (i < map.size()) {
            for (int next : map.get(now)) {
                if (next != pre) {
                    result[i] = next;
                    i++;
                    pre = now;
                    now = next;
                    break;
                }
            }
        }

        return result;
    }
}