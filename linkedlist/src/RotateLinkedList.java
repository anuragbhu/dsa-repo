public class RotateLinkedList {
    // TC = O(n), AS = O(1)
    public Node rotate(Node head, int k) {
        if(head == null) return null;

        k = k % getSize(head);

        if(k == 0)
            return head;

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        Node last = curr;
        curr = head;

        while(curr != null) {
            if(k <= 0)
                break;
            Node node = curr;
            k--;
            last.next = node;
            last = last.next;
            curr = curr.next;
        }
        last.next = null;
        return curr;
    }

    private int getSize(Node head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
