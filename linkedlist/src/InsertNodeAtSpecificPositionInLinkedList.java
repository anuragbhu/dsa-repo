public class InsertNodeAtSpecificPositionInLinkedList {
    // TC = O(n), As = O(1)
    public static Node insertNodeAtPosition(Node llist, int data, int position) {
        Node curr = llist;
        Node node = new Node(data);

        if(curr == null && position == 0) {
            curr = node;
            return llist;
        }

        int index = 0;
        while(curr != null) {
            if(index == position-1) {
                break;
            }
            index++;
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;

        return llist;
    }
}
