class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean result = dfs(root, head);
        result = result || isSubPath(head, root.left);
        result = result || isSubPath(head, root.right);
        return result;
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        boolean result = false;
        if (node.val == head.val) {
            result = dfs(node.left, head.next);
            result = result || dfs(node.right, head.next);
        }
        return result;
    }
}