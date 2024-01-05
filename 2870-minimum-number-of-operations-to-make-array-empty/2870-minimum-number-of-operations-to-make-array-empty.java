import java.util.HashMap;
import java.util.Map;

class Solution {

    private boolean isValid = true;

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = map.values().stream()
                .mapToInt(this::getMinSize)
                .sum();

        return !isValid ? -1 : result;
    }

    private int getMinSize(int count) {
        if (count == 1) {
            isValid = false;
            return 0;
        }

        if (count % 3 == 0) {
            return count / 3;
        }

        return count / 3 + 1;
    }
}
