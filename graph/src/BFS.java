import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    // Adjacency Matrix: TC = O(N * N), Adjacency List: TC = O(N + 2E)
    // Level Order Traversal in Tree
    public static void bfTraversal(int[][] adjMatrix, int currentVertex, boolean[] visited) {
        Queue<Integer> pendingVertices = new LinkedList<>(); // As Queue is an Interface
        visited[currentVertex] = true;
        pendingVertices.add(currentVertex);

        while (!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();
            System.out.print(front + " ");
            for(int i = 0; i < adjMatrix.length; i++) { // Optimize it using Adjacency List
                if(adjMatrix[front][i] == 1 && !visited[i])  {
                    // i.e. ith is the unvisited neighbour of the currentVertex
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void bfTraversal(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        // Traversing through all the nodes.
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bfTraversal(adjMatrix, i, visited);
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

        bfTraversal(adjMatrix);

        sc.close();
    }

    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        Queue<Integer> pendingVertices = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        visited[0] = true;
        pendingVertices.add(0);

        while(!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();
            res.add(front);
            for(int ele : adj.get(front)) {
                if(!visited[ele]) {
                    pendingVertices.add(ele);
                    visited[ele] = true;
                }
            }
        }
        return res;
    }
}
