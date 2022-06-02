public class PartitionList {
    // TC = O(n), AS = O(1)
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);

        ListNode before = before_head;
        ListNode after = after_head;

        while(head != null) {
            if(head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null; // Must be written otherwise makes cycle

        before.next = after_head.next;
        return before_head.next;
    }
}
