import java.util.ArrayList;
import java.util.Scanner;

/*
Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree.
The only catch here is, unlike trees, graphs may contain cycles (a node may be visited twice).
To avoid processing a node more than once, use a boolean visited array.

 */

public class DFS {

    // Adjacency Matrix: TC = O(N * N), Adjacency List: TC = O(N + 2E)
    // Smaller to Higher Value Print
    // Pre-Order Traversal in Tree
    public static void dfTraversal(int[][] adjMatrix, int currentVertex, boolean[] visited) {
        System.out.print(currentVertex + " ");
        visited[currentVertex] = true;
        for(int i = 0; i < adjMatrix.length; i++) {
            if(adjMatrix[currentVertex][i] == 1 && !visited[i])  {
                // i.e. ith is the neighbour of the currentVertex
                dfTraversal(adjMatrix, i, visited);
            }
        }
    }

    public static void dfTraversal(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        for(int i = 0; i < adjMatrix.length; i++) {
            if(!visited[i]) { // Handling disconnected graph
                dfTraversal(adjMatrix, i, visited);
                System.out.println(); // Print different components in separate line
            }
        }
    }

    // Implementation of Adjacency Matrix
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Vertices
        int e = sc.nextInt(); // Number of Edges

        int[][] adjMatrix = new int[n][n]; // All non-relevant cells should be marked as 0

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        dfTraversal(adjMatrix);

        sc.close();
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new  ArrayList<>();
        dfTraversal(adj, res);
        return res;
    }

    public static void dfTraversal(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited, ArrayList<Integer> res) {
        res.add(currentVertex);
        visited[currentVertex] = true;
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i); // Important
            if(!visited[node])  {
                dfTraversal(adj, node, visited, res);
            }
        }
    }

    public static void dfTraversal(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        boolean[] visited = new boolean[adj.size()];
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                dfTraversal(adj, i, visited, res);
            }
        }
    }
}
