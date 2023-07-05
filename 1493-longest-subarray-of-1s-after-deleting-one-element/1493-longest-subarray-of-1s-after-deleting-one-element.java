import java.util.LinkedList;
import java.util.List;

class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        for (int num : nums) {
            if (num != 1) {
                list.add(0);
            } else {
                int last = list.size() - 1;
                list.set(last, list.get(last) + 1);
            }
        }
        if (list.size() == 1){
            return nums.length - 1;
        }
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(max, list.get(i) + list.get(i + 1));
        }
        return max;
    }
}