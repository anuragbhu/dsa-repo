public class InsertionSortList {
    // TC = O(n^2), AS = O(1)
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode dummy = new ListNode(-5001), point; // as value b/w -5000 to 5000
        while (cur != null) {
            //locate the insertion position.
            point = dummy;
            while (point.next != null &&  cur.val > point.next.val) {
                point = point.next;
            }
            //insert between point and point.next.
            ListNode pointNext = point.next;
            point.next = cur;
            ListNode next = cur.next;
            cur.next = pointNext;
            cur = next;
        }
        return dummy.next;
    }
}
