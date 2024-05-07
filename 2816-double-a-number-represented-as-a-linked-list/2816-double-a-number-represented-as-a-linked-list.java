public class Solution {
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> values = new Stack<>();
        int val = 0;

        while (head != null) {
            values.push(head.val);
            head = head.next;
        }

        ListNode newTail = null;

        while (!values.isEmpty() || val != 0) {
            newTail = new ListNode(0, newTail);

            if (!values.isEmpty()) {
                val += values.pop() * 2;
            }
            newTail.val = val % 10;
            val /= 10;
        }

        return newTail;
    }
}