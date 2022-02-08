import java.util.Stack;

public class DeleteMiddleElementStack {
    // Function to delete middle element of a stack.
    // Iterative method
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        int middle = (int) Math.ceil(sizeOfStack/2);

        Stack<Integer> stack = new Stack<Integer>();

        int count = 0;
        while (count <= middle) {
            stack.push(s.pop());
            count++;
        }

        stack.pop();
        while(!stack.empty()) {
            s.push(stack.pop());
        }
    }
}
