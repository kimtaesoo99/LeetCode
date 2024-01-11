class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = root.val, max = root.val;
        diff(root, min, max);
        return gap;
    }

    public int gap = 0;

    public void diff(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        gap = Math.max(gap, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff(root.left, min, max);
        diff(root.right, min, max);
    }
}