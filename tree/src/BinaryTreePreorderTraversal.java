import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) {
            return res;
        }

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return res;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode curr = stack.pop();
            if(curr.right != null) {
                stack.push(curr.right);
            }
            if(curr.left != null) {
                stack.push(curr.left);
            }
            res.add(curr.val);
        }

        return res;
    }
}
