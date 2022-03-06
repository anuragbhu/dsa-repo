import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBTFromDescriptions {
    /*
      Concept : Use Hashmap to remember nodes. And at last to find root just see which node has no parent
      TC: O(Descriptions length)
      SC: O(Number of nodes)
    */
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] d : descriptions) {
            TreeNode p = map.getOrDefault(d[0], new TreeNode(d[0]));
            TreeNode c = map.getOrDefault(d[1], new TreeNode(d[1]));
            if (d[2] == 1) {
                p.left = c;
            } else
                p.right = c;

            map.put(d[0], p);
            map.put(d[1], c);
            set.add(c.val);
        }

        for (int key : map.keySet()) {
            if (!set.contains(key))
                return map.get(key);
        }
        return null;
    }
}
