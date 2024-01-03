import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();

        for (String b : bank) {
            int count = 0;
            for (char c : b.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            if (count != 0) {
                list.add(count);
            }
        }

        if (list.size() <= 1) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            result += list.get(i) * list.get(i + 1);
        }

        return result;
    }
}