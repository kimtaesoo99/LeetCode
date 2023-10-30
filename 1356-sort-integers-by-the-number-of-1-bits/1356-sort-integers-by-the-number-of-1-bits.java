import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr)
            .boxed()
            .toArray(Integer[]::new);
        
        Comparator<Integer> comparator = new compareBit();
        Arrays.sort(nums, comparator);
        
        return Arrays.stream(nums)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

class compareBit implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a - b;
        }

        return Integer.bitCount(a) - Integer.bitCount(b);
    }
}
