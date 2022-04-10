import java.util.ArrayList;
import java.util.Scanner;

class Nodes1 {
    private int u;
    private int v;
    private int w;

    public Nodes1(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }
}

/*
Negative Weight Cycle: Means cycle sum of weight in graph is negative.

Steps:
    1) Relax all edges (n-1) times by using below condition -  WHY?????
        if(distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
        }
    2) Check for negative weight cycle by using above condition one more time. If weight decreases more than there is
        a cycle of negative weight in the graph.
 */

// Time Complexity: O((n-1) * e) + O(e) (Step 1)
// Space Complexity: O(n) (Distance Array)
public class BellmanFordAlgorithm {
    public static boolean bellmanFord(ArrayList<Nodes1> adj, int n, int src, int[] distance) {

        distance[src] = 0; // Initializing at source index to 0. MUST CONDITION

        // Relax all edges (n-1) times
        for(int i = 1; i <= n-1; i++) {
            for(Nodes1 node : adj) {
                if(distance[node.getU()] + node.getW() < distance[node.getV()]) {
                    distance[node.getV()] = distance[node.getU()] + node.getW();
                }
            }
        }

        // Negative Cycle
        for(Nodes1 node : adj) {
            if(distance[node.getU()] + node.getW() < distance[node.getV()]) {
                return false;
            }
        }

        return true;
    }

    private static void addEdge(ArrayList<Nodes1> adjList, int u, int v, int w) {
        adjList.add(new Nodes1(u, v, w));
//        adjList.add(new Nodes1(v, u, w)); // Uncomment in case of undirected graph. Negative weight not allowed.
        // as it forms cycle.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Vertices
        int e = sc.nextInt(); // Number of Edges
        int src = sc.nextInt(); // Source Vertex

        ArrayList<Nodes1> adj = new ArrayList<>(n);

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            addEdge(adj, u, v, w);
        }

        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = 10000000; // Warning: It will give overflow value as (max + weight) is out of range of int.
            // and gives some negative value.
        }

        boolean flag = bellmanFord(adj, n, src, distance);

        if(flag) {
            for (int i = 0; i < n; i++) {
                System.out.println("Shortest distance between source vertex " + src + " to destination vertex " + i +
                        " is:" + " " + distance[i]);
            }
        } else {
            System.out.println("Negative Cycle");
        }
    }

    // (u, v, w) ---> Array each row in this form.
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[0] = 0; // Initializing at source index to 0. MUST CONDITION

        // Relax all edges (n-1) times
        for(int i=0; i<=n-1; i++){
            for(int j=0; j<edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                if(dis[u] == Integer.MAX_VALUE) /////// Correct approach
                    continue;

                if(dis[u] + w < dis[v]){
                    dis[v] = dis[u] + w;
                }
            }
        }

        // Negative Cycle
        for(int j=0; j<edges.length; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if(dis[u] == Integer.MAX_VALUE)
                continue;
            if(dis[u] + w < dis[v]){
                return 1;
            }
        }

        return 0;
    }
}
