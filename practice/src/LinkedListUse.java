import java.util.Scanner;

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

    public static void readLinkedList(Node<Integer> head) {
        Node<Integer> temp = head; // Common Practice
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        while(data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if(head == null) {
                head = currentNode;
            } else {
                Node<Integer> tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = currentNode;
            }
            data = sc.nextInt();
        }
        sc.close();
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = createLinkedList();
        readLinkedList(head);
    }
}
