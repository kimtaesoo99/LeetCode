import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            System.arraycopy(nums, l[i], arr, 0, arr.length);

            result.add(check(arr));
        }

        return result;
    }

    public Boolean check(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }

        int gap = (max - min) / (arr.length - 1);
        int now = min + gap;

        while (now < max) {
            if (!set.contains(now)) {
                return false;
            }

            now += gap;
        }

        return true;
    }
}
