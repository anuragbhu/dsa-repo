import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {
    // Function to detect cycle in an undirected graph.
    // Using DFS: Time Complexity: O(V+E) Space Complexity: O(V)
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        return dfTraversal(adj);
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited, int parent) {
        visited[currentVertex] = true;
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i); // Important
            if(!visited[node])  {
                if(dfTraversal(adj, node, visited, currentVertex)) {
                    return true;
                }
            } else if(node != parent) { // Main Idea
                return true;
            }
        }
        return false;
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        int parent = -1;
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                if(dfTraversal(adj, i, visited, parent)) return true;
            }
        }
        return false;
    }
}