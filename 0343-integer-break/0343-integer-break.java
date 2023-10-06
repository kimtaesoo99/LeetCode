import java.util.ArrayList;
import java.util.List;

class Solution {
    private int sum;
    private List<Integer> list = new ArrayList<>();

    public int integerBreak(int n) {
        combination(n);
        return sum;
    }

    private void combination(int n) {
        if (n == 0) {
            getSum();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) >= i) {
                list.add(i);
                combination(n - i);
                list.remove(list.size() - 1);
            }
        }
    }

    private void getSum() {
        if (list.size() < 2) {
            return;
        }
        int result = list.stream()
                .reduce(1, (i, j) -> i * j);
        sum = Math.max(sum, result);
    }
}