import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
            } else if(order[node]) { // Main idea is to check if current vertex is present or not in the path of
                // vertices.
                return true;
            }
        }
        order[currentVertex] = false; // Make false when moving back in current path.
        return false;
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()]; // // To check vertices are visited or not
        boolean[] order = new boolean[adj.size()]; // To check vertices are visited in current path or not
        int parent = -1;
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                if(dfTraversal(adj, i, visited, order, parent)) return true;
            }
        }
        return false;
    }

    // Function to detect cycle in a directed graph.
    // We are going to use the reverse logic as Topological Sort is not possible in
    // Directed Cyclic Graph
    // i.e. if topological sort is unable to generate than we can say that it's a D. Cyclic G.
    public boolean isCyclic1(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++) { // Logic for storing the in-degree of the vertices.
            for(int ele : adj.get(i)) {
                indegree[ele]++;
            }
        }

        Queue<Integer> pendingVertices = new LinkedList<>();

        for(int i = 0; i < V; i++) { // Adding vertices having in-degree as 0.
            if(indegree[i] == 0) {
                pendingVertices.add(i);
            }
        }
        int count = 0; // Count the number of topo sort vertices generated.
        while(!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();
            count++;
            for(int ele : adj.get(front)) {
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    pendingVertices.add(ele);
                }
            }
        }

        if(count == V) return false;

        return true;
    }
}
