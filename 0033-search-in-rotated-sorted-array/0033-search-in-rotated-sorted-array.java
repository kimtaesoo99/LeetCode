class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return shiftedBinarySearch(nums, left, target);
    }
    
    private int shiftedBinarySearch(int[] nums, int pivot, int target) {
        int n = nums.length;
        int shift = n - pivot;
        int left = (pivot + shift) % n;
        int right = (pivot - 1 + shift) % n;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[(mid - shift + n) % n] == target) {
                return (mid - shift + n) % n;
            } else if (nums[(mid - shift + n) % n] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}