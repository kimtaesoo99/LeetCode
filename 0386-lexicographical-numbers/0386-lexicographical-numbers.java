import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        String[] ans = new String[n];
        int i;
        for (i = 0; i < n; i++) {
            ans[i] = Integer.toString(i + 1);
        }
        Arrays.sort(ans);
        return Arrays.stream(ans)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
