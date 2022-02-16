import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    public Queue<Integer> rev(Queue<Integer> q){

        Stack<Integer> stack = new Stack<Integer>();

        while (!q.isEmpty()) {
            int ele = q.remove();
            stack.push(ele);
        }

        while (!stack.isEmpty()) {
            int ele = stack.pop();
            q.add(ele);
        }

        return q;
    }
}
