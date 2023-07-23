class Solution {
    private final HashMap<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return List.of(new TreeNode());
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    res.add(root);
                }
            }
        }
        map.put(n, res);
        return res;
    }
}