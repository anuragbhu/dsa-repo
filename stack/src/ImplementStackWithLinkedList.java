public class ImplementStackWithLinkedList {
    private Node head;
    int size;

    public ImplementStackWithLinkedList()
    {
        head = null;
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        size++;
        head = newNode;
    }

    public void pop()
    {
        if(head == null) return;

        head = head.next;
        size--;
    }

    public int getTop()
    {
        if(head == null) return -1;

        return (int) head.data;
    }
}
