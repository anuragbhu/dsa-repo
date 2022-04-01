import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInUnweightedGraph {
    // Using Modified Version of BFS: Time Complexity: O(V+E) Space Complexity: O(V) + O(V) (queue and distance array)
    public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int n, int src, int[] distance) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        pendingVertices.add(src);
        distance[src] = 0; // Distance between self node is zero.

        while(!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();
            for(int ele : adj.get(front)) {
                if((distance[front] + 1) < distance[ele]) { // Condition to modify distance
                    distance[ele] = distance[front] + 1;
                    pendingVertices.add(ele);
                }
            }
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int v1, int v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1); // Comment it to make it as a directed graph
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Vertices
        int e = sc.nextInt(); // Number of Edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addEdge(adj, v1, v2);
        }

        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        int src = 0;
        shortestPath(adj, n, src, distance);

        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance between source vertex " + src + " to destination vertex " + i +
                    " is:" + " " + distance[i]);
        }
    }
}