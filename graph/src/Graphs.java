import java.util.Scanner;

public class Graphs {

    // Worst case Time Complexity: O(N * N), Auxiliary Space: O(N * N) for both directed and undirected graphs.
    // Implementation of Adjacency Matrix
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Vertices
        int e = sc.nextInt(); // Number of Edges

        // If 1 based indexing is followed then make matrix of (n + 1) * (n + 1)
        int[][] adjMatrix = new int[n][n]; // All non-relevant cells should be marked as 0

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjMatrix[v1][v2] = 1; // 0 means edge is absent, 1 means edge is present.
            adjMatrix[v2][v1] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}