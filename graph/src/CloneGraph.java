import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node2 {
    public int val;
    public List<Node2> neighbors;
    public Node2() {
        val = 0;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val, ArrayList<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
// Using DFS: Time Complexity: O(V+E) Space Complexity: O(V) to store the Nodes Pair
public class CloneGraph {
    public static void addEdges(HashMap<Node2, Node2> hmap) {
        // iterate through map
        for(Node2 original : hmap.keySet()) { // Give keys in the form of set
            Node2 newNode = hmap.get(original);
            // System.out.print(original.val + "  " + newNode.val);
            // iterate through neighbours
            for(Node2 neighbor : original.neighbors) {
                // add the neighbors to new node neighbors arraylist
                newNode.neighbors.add(hmap.get(neighbor));
                // System.out.print(" --- > " + neighbor.val + "  " + hmap.get(neighbor).val);
            }
            // System.out.println();
        }
    }

    public static void dfs(Node2 node, HashMap<Node2, Node2> hmap) {
        // make the copy node
        Node2 newNode = new Node2(node.val);
        // insert node and its copy in map as pair
        hmap.put(node, newNode); // It also marks the newNode as visited

        // traverse through neighbors which are not visited
        for(Node2 ele : node.neighbors) {
            if(!hmap.containsKey(ele)) {
                // Undiscovered node
                dfs(ele, hmap);
            }
        }
    }

    public Node2 cloneGraph(Node2 node) {

        // As given the number of nodes in the graph is in the range [0, 100].
        if(node == null) return null;

        // Map for mapping node and node's copy
        HashMap<Node2, Node2> hmap = new HashMap<>();

        // Step 1. dfs
        dfs(node, hmap);

        // Traverse visited Set
        // for(Node2 ele : visited) {
        //     System.out.println(ele.val);
        // }

        // Step 2. Linking Process
        addEdges(hmap);

        return hmap.get(node);
    }
}
