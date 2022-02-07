import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        String res = "";

        for(int i = 0; i < exp.length(); i++) {
            char temp = exp.charAt(i);
            if((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')) {
                res += temp;
            } else if(temp == '(') {
                stack.push(temp);
            } else if(temp == ')') {
                while(!stack.empty() && stack.peek() != '(') {
                    res += stack.peek();
                    stack.pop();
                }
                if(!stack.empty()) {
                    stack.pop();
                }
            } else {
                while(!stack.empty() && (precedence(stack.peek()) >= precedence(temp))) {
                    res += stack.peek();
                    stack.pop();
                }
                stack.push(temp);
            }
        }
        while(!stack.empty()) {
            res += stack.peek();
            stack.pop();
        }

        return res;
    }

    private static int precedence(char ch) {
        if(ch == '^') {
            return 2;
        } else if(ch == '/' || ch == '*') {
            return 1;
        } else if(ch == '+' || ch == '-') {
            return 0;
        } else {
            return -1;
        }
    }
}
