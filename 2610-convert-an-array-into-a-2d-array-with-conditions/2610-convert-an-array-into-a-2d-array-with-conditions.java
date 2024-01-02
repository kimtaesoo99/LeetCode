class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= result.size()) {
                result.add(new ArrayList<>());
            }

            result.get(freq[c]).add(c);
            freq[c]++;
        }

        return result;
    }
}