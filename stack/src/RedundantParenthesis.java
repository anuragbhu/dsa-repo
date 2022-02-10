import java.util.Stack;

public class RedundantParenthesis {

    public static boolean checkRedundancy(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);

            if(temp == '('){
                stack.push(temp);
            } else if(isOperator(temp)) {
                stack.push(temp);
            } else if(temp == ')' && isOperator(stack.peek())) { // Must contain operator b/w parenthesis.
                while(!stack.empty() && stack.peek() != '(') {
                    stack.pop();
                }
                if(!stack.empty() && stack.peek() == '(')
                    stack.pop();
            }
        }
        return !stack.empty();
    }

    private static boolean isOperator(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;

        }
    }

    public static void main(String[] args) {
        System.out.println(checkRedundancy("((a+b))"));
        System.out.println(checkRedundancy("(a+(b)/c)"));
        System.out.println(checkRedundancy("(a+b*(c-d))"));
        System.out.println(checkRedundancy(""));
        System.out.println(checkRedundancy("()"));
        System.out.println(checkRedundancy("(())"));
    }
}
