import java.util.HashMap;
import java.util.Map;

class Solution {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String str : arr) {
            if (map.get(str) == 1) {
                k--;
            }
            if (k == 0) {
                return str;
            }
        }

        return "";
    }
}