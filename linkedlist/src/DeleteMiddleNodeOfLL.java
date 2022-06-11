public class DeleteMiddleNodeOfLL {
    // TC = O(n), AS = O(1)
    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        int size = getSize(head);
        if(size == 1)
            return null;
        int mid = size / 2;
        mid--;
        int index = 0;
        while(curr != null) {
            if(index == mid)
                break;
            index++;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    private int getSize(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // TC = O(n), AS = O(1)
    public ListNode deleteMiddle1(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while((fast != null) && (fast.next != null)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
