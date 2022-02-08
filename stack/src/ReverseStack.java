import java.util.Stack;

public class ReverseStack {

    public static void reverse(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while(!stack.empty()) {
            temp.push(stack.pop());
        }

        while (!temp.empty()) {
            stack.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(15);
        stack.push(18);

        reverse(stack);

        while(!stack.empty()) {
            System.out.printf(stack.pop() + " ");
        }
    }
}
