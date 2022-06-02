public class NodeAtGivenIndexInLinkedList {
    // TC = O(n), AS = O(1)
    public static int getNth(Node node, int ind) {
        if(node == null) return -1;

        Node curr = node;
        int index = 1;
        while(curr != null) {
            if(index == ind)
                return (int) curr.data;
            curr = curr.next;
            index++;
        }
        return -1;
    }
}
