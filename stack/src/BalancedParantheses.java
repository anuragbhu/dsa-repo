import java.util.Stack;

public class BalancedParantheses {
    public int solve(String A) {
        Stack<Character> parenthesis = new Stack<>();

        for(int i = 0; i < A.length(); i++) {
            char temp = A.charAt(i);

            if(temp == '(' || temp == '[' || temp == '{') {
                parenthesis.push(temp);
            } else {
                if(parenthesis.empty()) {
                    return 0;
                }

                if(temp == ')' && parenthesis.peek() == '(') {
                    parenthesis.pop();
                } else if(temp == '}' && parenthesis.peek() == '{') {
                    parenthesis.pop();
                } else if(temp == ']' && parenthesis.peek() == '[') {
                    parenthesis.pop();
                } else {
                    return 0;
                }
            }
        }
        if(parenthesis.empty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
