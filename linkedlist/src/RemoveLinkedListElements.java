public class RemoveLinkedListElements {
    // Definition for singly-linked list.
    // TC = O(n), AS = O(1)
    public ListNode removeElements(ListNode head, int val) {
// Remove - First, Index, Last
        if(head == null) return null;

        ListNode curr = head, prev = head;
        while(curr != null) {
            if(curr.val == val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return (head.val == val)? head.next : head;
    }
}
