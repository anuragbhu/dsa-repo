public class PrintLinkedListElements {
    // Print elements of a linked list on console
    // head pointer input could be NULL as well
    // for empty list
    // TC = O(n), AS = O(1)
    void display(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
