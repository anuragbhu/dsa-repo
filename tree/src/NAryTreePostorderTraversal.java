import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        traversal(root, res);
        return res;
    }

    public void traversal(Node root, List<Integer> res) {

        for(int i = 0; i < root.children.size(); i++) {
            traversal(root.children.get(i), res);
        }

        res.add(root.val);
    }
}
