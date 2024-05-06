 class Solution {   
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = removeNodes(head.next);

        if (head.val < nextNode.val) {
            return nextNode;
        }

        head.next = nextNode;
        return head;
    }
}