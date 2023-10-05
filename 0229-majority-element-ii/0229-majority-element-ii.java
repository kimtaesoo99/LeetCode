import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int standard = nums.length / 3;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if ((map.get(num)) > standard) {
                list.add(num);
                map.put(num, Integer.MIN_VALUE);
            }
        }
        
        return list;
    }
}