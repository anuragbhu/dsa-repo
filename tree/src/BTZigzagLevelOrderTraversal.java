import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> list = new ArrayList<>();
        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if(currNode == null) {
                res.add(new ArrayList<>(order(list, leftToRight)));
                list = new ArrayList<>();
                leftToRight = !leftToRight; // // reverse sign at each level
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

    private static List<Integer> order(List<Integer> arr, boolean leftToRight) {
        if(leftToRight)
            return arr;

        int temp, start = 0, end = arr.size()-1;

        while (start < end)
        {
            temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
        return arr;
    }
}
