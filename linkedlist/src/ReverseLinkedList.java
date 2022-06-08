public class ReverseLinkedList {
    // Pointer Iterative Approach
    // TC = O(n), AS = O(1)
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    // Data Iterative Approach
    // TC = O(n^2), AS = O(1)
    public ListNode reverseList1(ListNode head) {
        if(head == null)
            return null;

        int leftIndex = 0;
        int rightIndex = getSize(head) - 1;

        while(leftIndex <  rightIndex) {
            ListNode left = getNode(head, leftIndex);
            ListNode right = getNode(head, rightIndex);

            int temp = left.val;
            left.val = right.val;
            right.val = temp;

            leftIndex++;
            rightIndex--;
        }

        return head;
    }

    private ListNode getNode(ListNode curr, int index) {
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }

    private int getSize(ListNode curr) {
        int size = 0;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        return size;
    }
}
