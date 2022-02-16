import java.util.Stack;

public class StackImpl {
    public static void main(String[] args) {

        // Methods in Stack Class
        // Java Collection framework provides a Stack class that models and implements a Stack data structure.
        // Creating an empty Stack
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("Hi");
        stack.push("Welcome");

        // Default initialization of Stack
        Stack stack1 = new Stack();

        // Initialization of Stack using Generics
        Stack<String> stack2 = new Stack<>();

        // pushing the elements
        stack1.push(4);
        stack1.push("AllGeeks");

        stack2.push("Geeks");

        // Printing the Stack Elements
        System.out.println(stack1);
        System.out.println(stack2);

        // Fetching the element at the head of the Stack
        System.out.println(stack.peek());

        // Removing elements using pop() method
        System.out.println(stack.pop());

        // It returns true if nothing is on the top of the stack. Else, returns false.
        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());

        // It determines whether an object exists in the stack. If the element is found,
        // it returns the position of the element from the top of the stack. Else, it returns -1.
        // 1-based indexing of position
        System.out.println(stack.search("Hello"));

        // Loop
        while(!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
