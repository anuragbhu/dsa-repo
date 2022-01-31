public class StackUsingArray {

    private int[] data;
    private int topIndex;

    public StackUsingArray() {
        data = new int[10];
        topIndex = -1;
    }

    public StackUsingArray(int size) {
        data = new int[size];
        topIndex = -1;
    }

    // Time Complexity = O(1)
    public int size() {
        return topIndex + 1;
    }

    // Time Complexity = O(1)
    public boolean isEmpty() {
        return topIndex == -1;
    }

    // Time Complexity = O(1)
    public void push(int element) throws StackFullException {
        // If Stack is full.
        if(topIndex == data.length-1) {
            throw new StackFullException();
        }
        topIndex++;
        data[topIndex] = element;
    }

    // Time Complexity = O(1)
    public int top() throws StackEmptyException {
        // Stack Empty Exception
        if(topIndex == -1) {
            throw new StackEmptyException();
        }
        return data[topIndex];
    }

    // Time Complexity = O(1)
    public int pop() throws StackEmptyException {
        if(topIndex == -1) {
            throw new StackEmptyException();
        }
        int top = data[topIndex];
        topIndex--;
        return top;
    }
}
