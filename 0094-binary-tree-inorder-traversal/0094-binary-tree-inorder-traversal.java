class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    public void recursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursive(root.left, result);
            result.add(root.val);
            recursive(root.right, result);
        }
    }
}