public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode newHead = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null)
            return null;

        int leftIndex = 0;
        int rightIndex = getSize(head) - 1;

        ListNode curr = head;

        while(leftIndex <  rightIndex) {
            ListNode left = getNode(curr, leftIndex);
            ListNode right = getNode(curr, rightIndex);

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
