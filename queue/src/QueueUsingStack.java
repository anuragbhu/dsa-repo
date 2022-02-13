import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
        while(!input.empty()) {
            output.push(input.pop());
        }

        int ele = output.pop();

        while(!output.empty()) {
            input.push(output.pop());
        }

        return ele;
    }

    /* The method push to push element into the stack */
    void enqueue(int x)
    {
        input.push(x);
    }
}
