class Solution {
    int count = 0;
        
    public void preorder(TreeNode node, int path) {
        if (node != null) {
            path = path ^ (1 << node.val);
            if (node.left == null && node.right == null) {
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path) ;
        }
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }
}