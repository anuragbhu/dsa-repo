import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TravellingSalesmanProblem {

    /*

        1) Consider city 1 as the starting and ending point.
        2) Generate all (n-1)! Permutations of cities.
        3) Calculate cost of every permutation and keep track of minimum cost permutation.
        4) Return the permutation with minimum cost.


     */


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
            int w = sc.nextInt();

            adjMatrix[v1][v2] = w; // w is the weight
            adjMatrix[v2][v1] = w;
        }

        boolean[] visited = new boolean[n];
        int min_path = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
