import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// A Binary Tree node
class Nodes
{
    int data;
    Nodes left, right;

    Nodes(int item)
    {
        data = item;
        left = right = null;
    }
}

public class LeftViewOfBT {
    ArrayList<Integer> leftView(Nodes root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> ans = new ArrayList<Integer>();

        if(root == null) {
            return ans;
        }

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Nodes currNode = queue.remove();
            if(currNode == null) {
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                if(queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                list.add(currNode.data);
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        for(List<Integer> temp : res) {
            ans.add(temp.get(0));
        }

        return ans;

    }
}
