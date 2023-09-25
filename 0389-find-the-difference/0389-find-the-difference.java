import java.util.HashMap;
import java.util.Map;

class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) - 1);
        }

        return map.entrySet()
                .stream()
                .filter(i -> i.getValue() == 1)
                .map(i -> i.getKey())
                .findFirst()
                .orElse('a');
    }
}