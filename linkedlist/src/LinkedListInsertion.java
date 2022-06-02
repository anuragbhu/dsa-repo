public class LinkedListInsertion {
    //Function to insert a node at the beginning of the linked list.
    // TC = O(1), As = O(1)
    Node insertAtBeginning(Node head, int x) {
        Node node = new Node(x);
        node.next = head;
        return node;
    }

    //Function to insert a node at the end of the linked list.
    // TC = O(n), As = O(1)
    Node insertAtEnd(Node head, int x) {
        Node input = new Node(x);
        if(head == null) {
            return input;
        }
        Node n = head;
        while(n.next!=null) {
            n = n.next;
        }
        n.next = input;
        return head;
    }
}
