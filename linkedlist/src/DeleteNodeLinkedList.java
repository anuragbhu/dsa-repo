public class DeleteNodeLinkedList {
    // TC = O(1), AS = O(1)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
