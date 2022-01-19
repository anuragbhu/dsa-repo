public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // case 1: If head is null.
        if(head == null) {
            return head;
        }

        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        // case 2: If LL contains only 1 node.
        if(n == 1 && count == 1) {
            return null;
        }

        // case 3: If LL size is equal to n
        if(n == count) {
            return head.next;
        }

        int index = count - n;
        count = 1;
        curr = head;

        // case 4: If LL contains 2 or more elements.
        while(curr != null) {
            if(index == count) {
                curr.next = curr.next.next;
                break;
            }
            count++;
            curr = curr.next;
        }

        return head;
    }
}
