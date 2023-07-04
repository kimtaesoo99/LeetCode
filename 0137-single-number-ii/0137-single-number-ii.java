import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums)
            .forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        
        return Arrays.stream(nums)
            .filter(i -> map.get(i) == 1).findAny().orElse(0);
    }
}