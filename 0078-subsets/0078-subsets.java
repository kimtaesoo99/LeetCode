class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        explore(nums, 0, curr, result);
        return result;
    }

    private void explore(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        explore(nums, index + 1, curr, result);
        curr.remove(curr.size() - 1);

        explore(nums, index + 1, curr, result);
    }
}