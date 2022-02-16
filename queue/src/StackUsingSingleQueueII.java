import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueueII {

    Queue<Integer> queue = new LinkedList<>();

    public void push(int val) {
        queue.add(val);
        int rotate = 0;
        while (rotate < queue.size()-1) { // Ignore current element position
            int remove = queue.remove();
            queue.add(remove);
            rotate++;
        }
    }

    public int pop() {
        if(isEmpty()) return -1;
        return queue.remove();
    }

    public int top() {
        if (queue.isEmpty())
            return -1;
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        StackUsingSingleQueueII stack = new StackUsingSingleQueueII();

        int n = 3;
        for(int i = 0; i < n; i++) {
            stack.push(i);
        }

        System.out.println(stack.top());

        for(int i = 0; i < n; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.isEmpty());
    }
}
