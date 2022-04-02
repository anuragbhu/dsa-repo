import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// Time Complexity: O((V+E)logV) (Traversal and Priority Queue)
// Space Complexity: O(V) + O(V) + O(V) (Key Array, MST Array, Parent Array)
public class PrimsAlgorithmOptimised {

    public static void spanningTree(ArrayList<ArrayList<Nodes>> adj, int n) {
        // Key values used to pick minimum weight edge in cut
        int[] key = new int[n];

        // To represent set of vertices included in MST
        boolean[] mst = new boolean[n];

        // Array to store constructed MST
        int[] parent = new int[n];

        for(int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0; // Make key 0 so that this vertex is picked as first vertex.

        PriorityQueue<Nodes> pq = new PriorityQueue<>(n, new Nodes()); // Very Important
        pq.add(new Nodes(key[0], 0));

        // Why n-1 ? Because MST has n nodes and n-1 edges.
        while(!pq.isEmpty()) {
            int min_index = pq.poll().getVertex();
            mst[min_index] = true; // // Add the picked vertex to the MST Set

            for(Nodes nodes : adj.get(min_index)) {
                int v = nodes.getVertex();
                int w = nodes.getWeight();

                // mst[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if(!mst[v] && w < key[v]) {
                    key[v] = w;
                    parent[v] = min_index;
                    pq.add(new Nodes(nodes.getVertex(), key[nodes.getVertex()]));
                }
            }
        }

        // print the constructed MST
        for (int i = 1; i < n; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " with weight " + key[i]);
        }

    }

    private static void addEdge(ArrayList<ArrayList<Nodes>> adjList, int v1, int v2, int w) {
        adjList.get(v1).add(new Nodes(v2, w));
        adjList.get(v2).add(new Nodes(v1, w)); // Comment it to make it as a directed graph
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Vertices
        int e = sc.nextInt(); // Number of Edges

        ArrayList<ArrayList<Nodes>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            addEdge(adj, v1, v2, w);
        }

        spanningTree(adj, n);
    }
}
