import java.util.Stack;

public class SortAStack {

    public Stack<Integer> sort(Stack<Integer> s) {

        if(s.empty()) {
            return s;
        }

        int ele = s.pop();
        sort(s);
        maintainOrder(s, ele);
        return s;
    }

    public static void maintainOrder(Stack<Integer> s, int ele) {
        if(s.empty()) {
            s.push(ele);
            return;
        }


        if(!s.empty() && ele >= s.peek()) {
            s.push(ele);
            return;
        }

        int temp = s.pop();
        maintainOrder(s, ele);
        s.push(temp);
    }
}
