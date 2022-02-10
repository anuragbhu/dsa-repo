import java.util.Stack;

public class DeleteMiddleElementStack {
    // Function to delete middle element of a stack.
    // Iterative method
    public static void deleteMid(Stack<Integer>s,int sizeOfStack){
        int middle = (int) Math.ceil(sizeOfStack/2);

        Stack<Integer> stack = new Stack<Integer>();

        int count = 0;
        while (count <= middle) {
            stack.push(s.pop());
            count++;
        }

        stack.pop(); // removing middle element
        while(!stack.empty()) {
            s.push(stack.pop());
        }
    }

    //Function to delete middle element of a stack.
    // Recursive
    public static void deleteMid1(Stack<Integer>s,int sizeOfStack){
        int middle = (int) Math.ceil(sizeOfStack/2);
        int count = 0;
        deleteMidRecursive(s, count, middle);
    }

    public static void deleteMidRecursive(Stack<Integer>s, int count, int middle) {
        if(middle == count) {
            s.pop();
            return;
        }
        int ele = s.pop();
        deleteMidRecursive(s, count+1, middle);
        s.push(ele);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        deleteMid1(stack, 5);
        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
