import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {

    public static void push(Queue<Integer> queue, int val) {
        queue.add(val);
        int rotate = 0;
        while (rotate < queue.size()-1) { // Ignore current element position
            int remove = queue.remove();
            queue.add(remove);
            rotate++;
        }
    }

    public static int pop(Queue<Integer> queue) {
        if(isEmpty(queue)) return -1;
        return queue.remove();
    }

    public static int top(Queue<Integer> queue) {
        if (queue.isEmpty())
            return -1;
        return queue.peek();
    }

    public static boolean isEmpty(Queue<Integer> queue) {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        int n = 3;
        for(int i = 0; i < n; i++) {
            push(queue, i);
        }

        System.out.println(top(queue));

        for(int i = 0; i < n; i++) {
            System.out.println(pop(queue));
        }

        System.out.println(isEmpty(queue));
    }
}
