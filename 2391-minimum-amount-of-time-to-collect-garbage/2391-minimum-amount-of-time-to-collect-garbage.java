import java.util.HashMap;
import java.util.Map;

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        for (int i = 1; i < travel.length; i++) {
            travel[i] = travel[i - 1] + travel[i];
        }

        Map<Character, Integer> last = new HashMap<>();
        int result = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                last.put(c, i);
            }
            result += garbage[i].length();
        }

        String type = "MPG";
        for (char c : type.toCharArray()) {
            result += (last.getOrDefault(c, 0) == 0 ? 0 : travel[last.get(c) - 1]);
        }

        return result;
    }
}