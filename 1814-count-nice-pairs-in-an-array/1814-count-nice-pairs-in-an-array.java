import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : arr) {
            result = (result + map.getOrDefault(num, 0)) % MOD;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return result;
    }

    public int rev(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }
}