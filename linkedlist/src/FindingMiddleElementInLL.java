public class FindingMiddleElementInLL {
    // TC = O(n), AS = O(1)
    int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while((fast != null) && (fast.next != null)) {

            slow = slow.next;
            fast = fast.next.next;
        }
        return (int) slow.data;
    }

    // TC = O(n), AS = O(1)
    int getMiddle1(Node head) {
        int mid = getSize(head) / 2;
        int index = 0;
        while(head != null) {
            if(index == mid)
                return (int) head.data;
            index++;
            head = head.next;
        }
        return -1;
    }

    private int getSize(Node head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
