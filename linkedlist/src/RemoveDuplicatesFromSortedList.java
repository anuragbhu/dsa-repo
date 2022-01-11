public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null)
            return head;

        ListNode cur = head;

        while(head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return cur;

    }
}
