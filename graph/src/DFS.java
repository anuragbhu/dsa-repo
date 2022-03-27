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
        dfTraversal(adjMatrix, 0, visited);
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
}
