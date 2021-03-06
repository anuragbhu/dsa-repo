import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// If graph has odd length cycle ---> Not A Bipartite Graph
// If graph does not have odd length cycle ---> Bipartite Graph
// No cycle ---> Bipartite Graph
public class BipartiteGraph {
    // Using DFS: Time Complexity: O(V+E) Space Complexity: O(V+E) to store the adjacency list +
    // O(V) to store the color array + O(V) for auxiliary space of the recursion
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        return dfTraversal(adj);
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj, int currentVertex, int[] color) {
        if(color[currentVertex] == -1) {
            color[currentVertex] = 1;
        }
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i);
            if(color[node] == -1)  {
                color[node] = 1 - color[currentVertex];
                if(!dfTraversal(adj, node, color)) {
                    return false;
                }
            } else if(color[node] == color[currentVertex]) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[adj.size()];
        // 0 --> RED, 1 --> GREEN, Default --> -1
        Arrays.fill(color, -1);
        for(int i = 0; i < adj.size(); i++) { // Checking for the components of graph
            if(color[i] == -1) {
                if(!dfTraversal(adj, i, color)) return false;
            }
        }
        return true;
    }

    // Using BFS technique
    public boolean isBipartite1(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] color = new int[adj.size()];
        // 0 --> RED, 1 --> GREEN, Default --> -1
        Arrays.fill(color, -1);
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                if(!bfsOfGraph(adj, i, color)) return false;
            }
        }
        return true;
    }

    public static boolean bfsOfGraph(ArrayList<ArrayList<Integer>> adj, int currentVertex, int[] color) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        if(color[currentVertex] == -1) {
            color[currentVertex] = 1;
        }
        pendingVertices.add(currentVertex);

        while(!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();
            for(int ele : adj.get(front)) {
                if(color[ele] == -1) {
                    pendingVertices.add(ele);
                    color[ele] = 1 - color[front];
                } else if(color[ele] == color[front]) {
                    return false;
                }
            }
        }
        return true;
    }
}
