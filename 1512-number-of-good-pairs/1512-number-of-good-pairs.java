import java.util.HashMap;
import java.util.Map;

class Solution {
    private int result = 0;
    
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.entrySet()
                .stream()
                .filter(i -> i.getValue() != 1)
                .forEach(i -> result += getCount(i.getValue()));

        return result;
    }

    private int getCount(int i) {
        int sum = 0;
        for (int j = i - 1; j >= 1; j--) {
            sum += j;
        }
        return sum;
    }
}