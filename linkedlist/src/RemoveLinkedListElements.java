public class RemoveLinkedListElements {
     // Definition for singly-linked list.
    public ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return head;

        ListNode prev = head;
        ListNode cur = head;

        while(head != null) {
            if(head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }

        return cur.val == val ? cur.next : cur;

    }
}
