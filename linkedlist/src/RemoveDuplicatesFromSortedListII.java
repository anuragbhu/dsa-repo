public class RemoveDuplicatesFromSortedListII {
    // TC = O(n), AS = O(1)
    public ListNode deleteDuplicates(ListNode head) {
        // For single or no node
        if(head == null || head.next == null)
            return head;

        // dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev = the last node
        // before the sublist of duplicates
        ListNode prev = dummy;

        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                prev.next = head.next;
                // otherwise, move prev
            } else {
                prev = prev.next;
            }

            // move forward
            head = head.next;
        }
        return dummy.next;
    }
}
