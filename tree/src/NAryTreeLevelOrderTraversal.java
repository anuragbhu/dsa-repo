import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node currNode = queue.remove();
            list.add(currNode.val);
            for(int i = 0; i < currNode.children.size(); i++) {
                queue.add(currNode.children.get(i));
            }

            if(queue.peek() == null) {
                res.add(new ArrayList<>(list));
                queue.remove();
                list = new ArrayList<>();
                if(!queue.isEmpty()) {
                    queue.add(null);
                } else {
                    break;
                }

            }
        }

        return res;
    }
}
