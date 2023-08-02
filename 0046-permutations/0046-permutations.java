import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, nums);
        return result;
    }

    public void backtrack(List<Integer> now, List<List<Integer>> result, int[] nums) {
        if (now.size() == nums.length) {
            result.add(new ArrayList<>(now));
            return;
        }
        for (int num : nums) {
            if (!now.contains(num)) {
                now.add(num);
                backtrack(now, result, nums);
                now.remove(now.size() - 1);
            }
        }
    }
}