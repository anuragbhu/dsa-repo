public class SwapNodesInPairs {
    // TC = O(n), AS = O(1)
    public ListNode swapPairs(ListNode head) {
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode dummyO = dummyOdd;
        ListNode dummyE = dummyEven;

        int index = 1;
        while(head != null) {
            if(index % 2 == 0) {
                dummyE.next = head;
                dummyE = dummyE.next;
            } else {
                dummyO.next = head;
                dummyO = dummyO.next;
            }
            index++;
            head = head.next;
        }

        dummyE.next = null;
        dummyO.next = null;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        dummyOdd = dummyOdd.next;
        dummyEven = dummyEven.next;

        index = 1;
        while(dummyOdd != null && dummyEven != null) {
            if(index % 2 == 0) {
                curr.next = dummyOdd;
                curr = curr.next;
                dummyOdd = dummyOdd.next;
            } else {
                curr.next = dummyEven;
                curr = curr.next;
                dummyEven = dummyEven.next;
            }
            index++;
        }

        if(dummyOdd != null)
            curr.next = dummyOdd;

        if(dummyEven != null)
            curr.next = dummyEven;

        return dummy.next;
    }
}
