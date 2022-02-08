import java.util.Stack;

public class PrefixToInfix {

    public static String prefixToInfix(String str) {
        String res = "";
        Stack<String> stack  = new Stack<>();

        for(int i = str.length() - 1; i >= 0; i--) {
            char temp = str.charAt(i);
            if(isOperand(temp)) {
                stack.push(str.substring(i, i+1));
            } else if(!stack.isEmpty()) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp1 = "(" + op1 + str.charAt(i) + op2 + ")";
                stack.push(temp1);
            }
        }

        if(!stack.isEmpty())
            res = stack.pop();

        return res;
    }

    public static boolean isOperand(char ch) {
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(prefixToInfix("*-A/BC-/AKL"));
    }
}
