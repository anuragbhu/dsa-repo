import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        if(stack.empty()) {
            stack.push(val);
            min.push(val);
        } else if(!stack.empty()) {
            stack.push(val);
            /*
            why <= sign?
            Use below test case:
            ["MinStack","push","push","push","getMin","pop","getMin"]
            [[],[0],[1],[0],[],[],[]]
             */
            if(val <= min.peek()) { // for same element insertion
                min.push(val);
            }
        }
    }

    public void pop() {
        if(stack.empty()) {
            return;
        }
        int val = stack.pop();
        if(val == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if(stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(min.empty()) {
            return -1;
        }
        return min.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */