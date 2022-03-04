import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return res;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // Think Similar to the Recursive function using Stack as Auxiliary Space.
        while(true) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if(stack.empty()) {
                    break;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }
}
