import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();

        if(root == null) {
            return ans;
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

        for(List<Integer> temp : res) {
            int last = temp.size()-1;
            ans.add(temp.get(last));
        }

        return ans;
    }
}
