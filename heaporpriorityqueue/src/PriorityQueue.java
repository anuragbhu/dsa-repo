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

        while(childIndex > 0) { // break when child and parent index is same
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

    public T removeMin() {
        return heap.get(0).value;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
