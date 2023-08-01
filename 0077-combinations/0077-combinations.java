import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        combination(1, n, k, new ArrayList<>());
        return result;
    }

    public void combination(int start, int n, int k, List<Integer> now) {
        if (k == 0) {
            result.add(new ArrayList<>(now));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            now.add(i);
            combination(i + 1, n, k - 1, now);
            now.remove(now.size() - 1);
        }
    }
}