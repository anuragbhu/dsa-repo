import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int current;
    int parent;

    public Node(int current, int parent) {
        this.current = current;
        this.parent = parent;
    }
}

public class DetectCycleInUndirectedGraph {
    // Function to detect cycle in an undirected graph.
    // Using DFS: Time Complexity: O(V+E) Space Complexity: O(V)
    // If current's next node is visited, and it's not a parent node ---> Cycle Exist
    // It's mainly to differentiate between previous and next node.
    // i.e. if the next node of current is visited, and it's not the previous node then we are in a cycle.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        return dfTraversal(adj);
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited, int parent) {
        visited[currentVertex] = true;
        for (int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i); // Important
            if (!visited[node]) {
                if (dfTraversal(adj, node, visited, currentVertex)) {
                    return true;
                }
            } else if (node != parent) { // Main Idea
                return true;
            }
        }
        return false;
    }

    public static boolean dfTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        int parent = -1;
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfTraversal(adj, i, visited, parent)) return true;
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    // Using BFS technique
    public static boolean isCycle1(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (bfsOfGraph(adj, i, visited)) return true;
            }
        }
        return false;
    }

    public static boolean bfsOfGraph(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited) {
        Queue<Node> pendingVertices = new LinkedList<>();
        pendingVertices.add(new Node(currentVertex, -1));
        visited[currentVertex] = true;

        while (!pendingVertices.isEmpty()) {
            int current = pendingVertices.peek().current;
            int parent = pendingVertices.peek().parent;
            pendingVertices.remove();

            for (int ele : adj.get(current)) {
                if (!visited[ele]) {
                    pendingVertices.add(new Node(ele, current));
                    visited[ele] = true;
                } else if (parent != ele) {
                    return true;
                }
            }
        }
        return false;
    }
}