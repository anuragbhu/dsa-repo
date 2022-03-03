import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if(currNode == null) {
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                if(queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                list.add(currNode.val);
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return res;

    }
}
