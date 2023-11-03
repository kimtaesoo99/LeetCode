import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList();
        int i = 0;

        for (int num : target) {
            while (i < num - 1) {
                result.add("Push");
                result.add("Pop");
                i++;
            }

            result.add("Push");
            i++;
        }

        return result;
    }
}
