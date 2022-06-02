public class RemoveNthNodeFromEndofList {
    private int getSize(ListNode curr) {
        int size = 0;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    // TC = O(n), AS = O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // n is 1-based indexing (assume)
        // case 1: If head is null.
        if(head == null) {
            return head;
        }

        ListNode curr = head;
        int size = getSize(curr);

        // case 2: If n > size.
        // Only for Info purpose --- 1 <= n <= size

        // case 3: If LL contains only 1 node.
        if(n == 1 && size == 1) {
            return null;
        }

        // case 4: If LL size is equal to n
        if(n == size) {
            return head.next;
        }

        int index = size - n;
        size = 1;

        // case 5: If LL contains 2 or more elements.
        while(curr != null) {
            if(index == size) {
                curr.next = curr.next.next;
                break;
            }
            size++;
            curr = curr.next;
        }
        return head;
    }
}
