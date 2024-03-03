public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode x = head;
        int cnt = 0;
        while (x != null) {
            x = x.next;
            cnt++;
        }
        if (cnt == n) {
            ListNode temp = head.next;
            head = null;
            return temp;
        }
        x = head;
        int m = cnt - n;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int i = 0; i < m; i++) {
            temp.next = x;
            temp = temp.next;
            x = x.next;
        }
        temp.next = x.next;
        ListNode result = dummy.next;
        dummy = null;
        return result;
    }
}