import java.util.ArrayList;
import java.util.List;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        traversal(root, res);
        return res;
    }

    public void traversal(Node root, List<Integer> res) {

        res.add(root.val);

        for(int i = 0; i < root.children.size(); i++) {
            traversal(root.children.get(i), res);
        }
    }
}
