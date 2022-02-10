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

    public static void reverseStack(Stack<Integer> stack) {
        if(stack.empty())
            return;

        int ele = stack.pop();
        reverseStack(stack);
        insertAtBottom(ele, stack);
    }

    // Empty stack and then add element
    public static void insertAtBottom(int ele, Stack<Integer> stack) {
        if(stack.empty()) {
            stack.push(ele);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(ele, stack);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(15);
        stack.push(18);

        reverseStack(stack);

        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
