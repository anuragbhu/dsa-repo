import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    // Adjacency Matrix: TC = O(N * N), Adjacency List: TC = O(N + 2E)
    // Level Order Traversal in Tree
    public static void bfTraversal(int[][] adjMatrix) {
        Queue<Integer> pendingVertices = new LinkedList<>(); // As Queue is an Interface
        boolean[] visited = new boolean[adjMatrix.length];
        visited[0] = true;
        pendingVertices.add(0);

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex + " ");
            for(int i = 0; i < adjMatrix.length; i++) { // Optimize it using Adjacency List
                if(adjMatrix[currentVertex][i] == 1 && !visited[i])  {
                    // i.e. ith is the unvisited neighbour of the currentVertex
                    pendingVertices.add(i);
                    visited[i] = true;
                }
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
}
