import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    // Function to detect cycle in a directed graph.
    // Using DFS: Time Complexity: O(V+E) Space Complexity: O(V)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        return dfTraversal(adj);
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited, boolean[] order, int parent) {
        visited[currentVertex] = true;
        order[currentVertex] = true;
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i); // Important
            if(!visited[node])  {
                if(dfTraversal(adj, node, visited, order, currentVertex)) {
                    return true;
                }
            } else if(order[node]) { // Main Idea
                return true;
            }
        }
        order[currentVertex] = false;
        return false;
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] order = new boolean[adj.size()];
        int parent = -1;
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                if(dfTraversal(adj, i, visited, order, parent)) return true;
            }
        }
        return false;
    }
}
