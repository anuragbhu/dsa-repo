import java.util.Stack;

public class InfixToPrefix {

    private static String infixToPrefix(String str) {
        String original = "";

        // reverse parenthesis sign as well as reverse the string.
        // removed equality sign at line no. 50.
        for(int i =  str.length()-1; i >= 0; i--) {
            char temp = str.charAt(i);
            if(temp == '(') {
                original += ')';
            } else if (temp == ')') {
                original += '(';
            } else {
                original += temp;
            }
        }

        String res = infixToPostfix(original);

        original = "";
        for(int i =  res.length()-1; i >= 0; i--) {
            original += res.charAt(i);
        }

        return original;
    }

    private static String infixToPostfix(String exp) {
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
                while(!stack.empty() && (precedence(stack.peek()) > precedence(temp))) {
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

    public static void main(String[] args) {
        System.out.println(infixToPrefix("(a-b/c)*(a/k-l)")); // *-a/bc-/akl
//        System.out.println(infixToPrefix("x+y*z/w+u")); // ++x/*yzwu
    }
}
