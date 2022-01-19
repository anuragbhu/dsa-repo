public class NodeAtGivenIndexInLinkedList {
    public static int getNth(Node node, int ind)
    {
        Node current = node;
        int count = 0;

        while (current != null)
        {
            if (count == ind-1)
                return (int) current.data;
            count++;
            current = current.next;
        }

        return -1;
    }
}
