import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExistsInGraph {

    // TLE Approach
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // There are no self edges.
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean[] visited = new boolean[n];
        pendingVertices.add(source);
        visited[source] = true;

        while(!pendingVertices.isEmpty()) {
            int node = pendingVertices.poll();
            if(node == destination) return true;
            for(int i = 0; i < edges.length; i++) {
                // edges[i][0] = u, edges[i][1] = v and adding verting not already visited
                if(edges[i][0] == node && !visited[edges[i][1]]) {
                    pendingVertices.add(edges[i][1]);
                    // edges[i][0] = v, edges[i][1] = u and adding verting not already visited
                } else if(edges[i][1] == node && !visited[edges[i][0]]) {
                    pendingVertices.add(edges[i][0]);
                }
            }
        }
        return false;
    }

    // Approach: Solve by creating undirected graph. Otherwise, get TLE.
    // Time Complexity: O(N + E)  (BFS)
    // Space Complexity: O(N + E) + (N) + O(N) (Adjacency List, Visited Array, Stack)
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] ele : edges) {
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
        }

        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean[] visited = new boolean[n];
        pendingVertices.add(source);
        visited[source] = true;

        while(!pendingVertices.isEmpty()) {
            int node = pendingVertices.poll();
            if(node == destination) return true;
            for(int ele : adj.get(node)) {
                if(!visited[ele]) {
                    pendingVertices.add(ele);
                    visited[ele] = true;
                }
            }
        }
        return false;
    }
}
