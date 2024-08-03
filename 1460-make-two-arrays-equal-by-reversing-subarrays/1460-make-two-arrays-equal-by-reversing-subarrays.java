import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : target) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) - 1);
            } else {
                return false;
            }
        }

        return map.values().stream()
                .allMatch(i -> i == 0);
    }
}
