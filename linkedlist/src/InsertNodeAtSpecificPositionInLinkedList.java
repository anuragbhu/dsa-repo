public interface InsertNodeAtSpecificPositionInLinkedList {
    public static Node insertNodeAtPosition(Node llist, int data, int position) {
        Node head = llist;
        Node node = new Node(data);

        if(position == 0) {
            node.next = head;
            return node;
        }
        int count = 0;
        while(head != null) {
            count++;
            if(count == position) {
                node.next = head.next;
                head.next = node;
                return llist;
            }
            head = head.next;
        }

        return llist;

    }
}
