public class RemoveDuplicatesFromSortedList {
    // TC = O(n), AS = O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode curr = head;

        while(head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return curr;
    }
}
