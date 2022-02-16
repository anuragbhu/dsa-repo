import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

        Stack<Integer> stack = new Stack<Integer>();

        int count = 0;
        while(count < k) {
            stack.push(q.remove());
            count++;
        }

        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }

        count = 0;
        while(count < (q.size() - k)) {
            q.add(q.remove());
            count++;
        }

        return q;
    }
}
