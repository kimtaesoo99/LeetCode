import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getCount(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getCount(int[] nums, int limit) {
        int index = 0;
        int count = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] - nums[index] <= limit) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
}