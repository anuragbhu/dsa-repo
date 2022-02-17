import java.util.Stack;

public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {

        if (A.isEmpty() || A.equals("/")) return "/";

        String res = "";
        String[] str = A.split("/+");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < str.length; i++) {
            if(str[i].equals(".") || str[i].equals("")) {
                continue;
            } else if(str[i].equals("..")) {
                if(!stack.empty())
                    stack.pop();
            } else {
                stack.push(str[i]);
            }
        }

        for (String name : stack) {
            res += "/";
            res += name;
        }

        String result = "";
        if(res.length() == 0 || res.charAt(0) != '/') {
            result = "/" + res;
        } else {
            result = res;
        }

        return result;
    }
}
