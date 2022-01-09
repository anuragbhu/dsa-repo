public class LinkedListUse {

    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head; // Common Practice
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void increment(Node<Integer> head) {
        Node<Integer> temp = head; // Common Practice
        while(temp != null) {
            temp.data++;
            temp = temp.next;
        }
        print(head);
    }

    public static int length(Node<Integer> head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public static int ithNode(Node<Integer> head, int index) {
        int count = 0;
        while(head != null) {
            if(count == index)
                return head.data;
            count++;
            head = head.next;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        Node<Integer> head = createLinkedList();
        print(head);
        increment(head);
        System.out.println(length(head));
        System.out.println(ithNode(head, 2));

//        Node<Integer> n1 = new Node<>(10);
//        System.out.println(n1);
//        System.out.println(n1.data);
//        System.out.println(n1.next);
    }
}
