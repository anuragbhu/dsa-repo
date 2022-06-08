public class OddEvenLinkedList {
    // TC = O(n), AS = O(1)
    public ListNode oddEvenList(ListNode head) {
        ListNode curr = head;

        ListNode odd = new ListNode(0);
        ListNode oddDummy = odd;
        ListNode even = new ListNode(0);
        ListNode evenDummy = even;

        int index = 1; // One based indexing
        while(curr != null) {
            if(index % 2 == 0) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
            index++;
        }
        odd.next = evenDummy.next;
        even.next = null;

        return oddDummy.next;
    }
}
