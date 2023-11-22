import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                if (!map.containsKey(diagonal)) {
                    map.put(diagonal, new ArrayList<>());
                }

                map.get(diagonal).add(nums.get(row).get(col));
                n++;
            }
        }

        int[] result = new int[n];
        int i = 0;
        int now = 0;

        while (map.containsKey(now)) {
            for (int num : map.get(now)) {
                result[i] = num;
                i++;
            }
            now++;
        }

        return result;
    }
}