public class MergeListsAlternatingly {
    public void mergeAlt(Node head1, Node head2){

        Node node1Next, node2Next;
        Node first = head1;
        Node second = head2;

        while((first != null) && (second != null)) {
            node1Next = first.next;
            first.next = second;
            first = node1Next;

            node2Next = second.next;
            second.next = node1Next; // Connect
            second = node2Next;
        }

        head2 = second;

        while(head1 != null) {
            System.out.print(head1.data + " ");
            head1 = head1.next;
        }
        System.out.println();

        while(head2 != null) {
            System.out.print(head2.data + " ");
            head2 = head2.next;
        }

    }
}
