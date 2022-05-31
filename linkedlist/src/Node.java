public class Node<T> {
    T data;
    Node<T> next; // default value of any reference in an object is null.

    Node(T data) {
        this.data = data;
    }
}
