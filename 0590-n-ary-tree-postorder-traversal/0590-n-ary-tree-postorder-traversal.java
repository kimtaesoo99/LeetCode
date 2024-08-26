class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversePostorder(root, result);
        return result;
    }

    private void traversePostorder(
        Node currentNode,
        List<Integer> postorderList
    ) {
        if (currentNode == null) {
            return;
        }

        for (Node childNode : currentNode.children) {
            traversePostorder(childNode, postorderList);
        }

        postorderList.add(currentNode.val);
    }
}