import java.util.Scanner;

public class LinkedListUse {
    // TC = O(n), AS = O(1)
    public static Node<Integer> createLinkedList() {
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt(); // -1 that we are at end of the LL. // 2 3 4 5 -1

        while(data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if(head == null) {
                // This node is the head node
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        sc.close();
        return head;
    }
    // TC = O(n), AS = O(1)
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head; // Common Practice
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // TC = O(n), AS = O(1)
    public static int length(Node<Integer> head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    // TC = O(n), AS = O(1)
    public static int ithNode(Node<Integer> head, int index) {
        int i = 0;
        while(head != null) {
            if(i == index)
                return head.data;
            i++;
            head = head.next;
        }
        return Integer.MIN_VALUE;
    }

    // TC = O(n), AS = O(1)
    public static void increment(Node<Integer> head) {
        Node<Integer> temp = head; // Common Practice
        while(temp != null) {
            temp.data++;
            temp = temp.next;
        }
        print(head);
    }

    public static void main(String[] args) {
        Node<Integer> head = createLinkedList();
        print(head);
        System.out.println(length(head));
        System.out.println(ithNode(head, 2));
        increment(head);
    }
}
