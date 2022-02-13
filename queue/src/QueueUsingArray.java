public class QueueUsingArray {

    private int[] data;
    private int front; // index of the element at the front of the queue
    private int rear; // index of the element at the rear of the queue
    private int size;

    // The default constructor is the no-argument constructor automatically generated
    // unless you define another constructor. Any uninitialised fields will be set to their default values.
    public QueueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    // Time Complexity = O(1)
    public int size() {
        return size;
    }

    // Time Complexity = O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // Time Complexity = O(1)
    public void enqueue(int elem) {
        if(size == data.length) {
//            throw new QueueFullException();
            doubleCapacity();
        }

        if(size == 0) {
            front = 0;
        }
//        rear++;
//        // Circular Queue
//        if(rear == data.length) {
//            rear = 0;
//        }
        rear = (rear + 1) % data.length;
        data[rear] = elem;
        size++;
    }

    // Time Complexity = O(n)
    private void doubleCapacity() {
        int[] temp = data;
        data = new int[2 * temp.length];
        int index = 0;
        for(int i =  front; i < temp.length; i++) {
            data[index] = temp[i];
            index++;
        }
        for(int i =  0; i < front - 1; i++) {
            data[index] = temp[i];
            index++;
        }
        front = 0;
        rear = temp.length - 1;
    }

    // Time Complexity = O(1)
    public int front() throws QueueEmptyException {
        if(size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    // Time Complexity = O(1)
    public int dequeue() throws QueueEmptyException{
        if(size == 0) {
            throw new QueueEmptyException();
        }
        int elem = data[front];
//        front++;
//        // Circular Queue
//        if(front == data.length) {
//            front = 0;
//        }
        front = (front + 1) % data.length;
        size--;
        if(size == 0) {
            front = rear = -1;
        }
        return elem;
    }
}