import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) {
            return res;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);

        return res;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        Stack<TreeNode> resStack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        temp.push(root);

        while(!temp.empty()) {
            TreeNode curr = temp.pop();
            if(curr.left != null) {
                temp.push(curr.left);
            }
            if(curr.right != null) {
                temp.push(curr.right);
            }
            resStack.add(curr);
        }

        while(!resStack.empty()) {
            TreeNode curr = resStack.pop();
            res.add(curr.val);
        }

        return res;
    }
}
