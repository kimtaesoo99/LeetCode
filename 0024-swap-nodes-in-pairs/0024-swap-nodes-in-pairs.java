class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode next = null;
        ListNode temp = null;
        temp = head;
        
        while(temp != null){
            int t = temp.val;
            if(temp.next != null){
                temp.val = temp.next.val;
                temp.next.val = t;
                temp = temp.next;
            }
            temp = temp.next;
        }
        
        return head;
    }
}