import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> size = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!size.containsKey(groupSizes[i])) {
                size.put(groupSizes[i], new ArrayList<>());
            }

            List<Integer> group = size.get(groupSizes[i]);
            group.add(i);

            if (group.size() == groupSizes[i]) {
                result.add(group);
                size.remove(groupSizes[i]);
            }
        }

        return result;
    }
}
