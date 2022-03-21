import java.util.ArrayList;

public class PriorityQueue<T> {
    private ArrayList<Element<T>> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        Element<T> e = new Element<>(value, priority);
        heap.add(e);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0) { // break when child and parent index is same --- > Up-Heapify
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            } else {
                break; // Break when priority of parent index is less than child index
            }
        }
    }

    public T getMin() throws PriorityQueueException {
        if(isEmpty())
            throw new PriorityQueueException();

        return heap.get(0).value;
    }

    public T removeMin() throws PriorityQueueException{
        if(isEmpty())
            throw new PriorityQueueException();

        Element<T> removed = heap.get(0);
        T val = removed.value;

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1; // By Default 0
        int rightChildIndex = 2 * parentIndex + 2; // By Default 0

        while(leftChildIndex < heap.size()) { // Down-Heapify
            int minIndex = parentIndex; // By Default Initializing

            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }

            // Checking also if right child index exists or not
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = rightChildIndex;
            }

            if(parentIndex == minIndex) { // When parentIndex with priority placed at correct position.
                break;
            }

            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }

        return val;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
