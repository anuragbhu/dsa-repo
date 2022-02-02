public class StackUsingLL<T> {

    private Node<T> head;
    private int size;

    public StackUsingLL() {
        head = null;
        size = 0;
    }

    // Time Complexity = O(1)
    public int size() {
        return size;
    }

    // Time Complexity = O(1)
    public void push(T elem) {
        Node<T> newNode = new Node<T>(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Time Complexity = O(1)
    public T pop() throws StackEmptyException {
        if(head == null) {
            throw new StackEmptyException();
        }
        T temp = head.data;
        head = head.next;
        size --;
        return temp;
    }

    // Time Complexity = O(1)
    public T top() throws StackEmptyException {
        if(head == null) {
            throw new StackEmptyException();
        }
        return head.data;
    }

    // Time Complexity = O(1)
    public boolean isEmpty() {
        return size == 0;
    }
}
