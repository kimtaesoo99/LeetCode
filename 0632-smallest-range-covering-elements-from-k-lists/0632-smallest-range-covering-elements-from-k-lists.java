class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] indices = new int[k];
        int[] range = new int[] { 0, Integer.MAX_VALUE };

        while (true) {
            int curMin = Integer.MAX_VALUE, curMax =
                Integer.MIN_VALUE, minListIndex = 0;

            for (int i = 0; i < k; i++) {
                int currentElement = nums.get(i).get(indices[i]);

                if (currentElement < curMin) {
                    curMin = currentElement;
                    minListIndex = i;
                }

                if (currentElement > curMax) {
                    curMax = currentElement;
                }
            }

            if (curMax - curMin < range[1] - range[0]) {
                range[0] = curMin;
                range[1] = curMax;
            }

            if (++indices[minListIndex] == nums.get(minListIndex).size()) {
                break;
            }
        }

        return range;
    }
}