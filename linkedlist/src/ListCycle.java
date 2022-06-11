import java.util.HashSet;

public class ListCycle {
    // TC = O(n), AS = O(n)
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    // TC = O(n), AS = O(1)
    public boolean hasCycle1(ListNode head) {
        // if head is NULL then return false;
        if(head == null)
            return false;

        // making two pointers fast and slow and assignning them to head
        ListNode fast = head;
        ListNode slow = head;

        // till fast and fast-> next not reaches NULL
        // we will increment fast by 2 step and slow by 1 step
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;


            // At the point if fast and slow are at same address
            // this means linked list has a cycle in it.
            if(fast == slow) {
                System.out.println(fast.val);
                return true;
            }
        }

        // if traversal reaches to NULL this means no cycle.
        return false;
    }
}
