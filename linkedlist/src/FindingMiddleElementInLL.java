public class FindingMiddleElementInLL {
    int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;


        while((fast != null) && (fast.next != null)) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return (int) slow.data;
    }

    int getMiddle1(Node head) {
        Node curr = head;
        int size = 0;

        // Getting size
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        size = (size / 2) + 1;

        curr = head;

        int position = 0;
        while(curr != null) {
            position++;
            if(position == size)
                return (int) curr.data;
            curr = curr.next;
        }

        return -1;
    }
}
