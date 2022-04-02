import java.util.*;

class Nodes implements Comparator<Nodes>{
    int vertex;
    int weight;

    public Nodes(int vertex, int weight) {
        this.weight = weight;
        this.vertex = vertex;
    }

    public Nodes() {

    }

    public int getWeight() {
        return weight;
    }

    public int getVertex() {
        return vertex;
    }

    @Override
    public int compare(Nodes node1, Nodes node2)
    {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}
// Time Complexity: O((V+E)logV) (Traversal and Priority Queue)
// Space Complexity: O(V) + O(V) (Priority Queue and distance array)
public class DijkstrasAlgorithm {

    public static void shortestPath(ArrayList<ArrayList<Nodes>> adj, int n, int src, int[] distance) {
        PriorityQueue<Nodes> pq = new PriorityQueue<>(n, new Nodes()); // Very Important
        pq.add(new Nodes(src, 0));
        distance[src] = 0; // Distance between self node is zero.

        while(pq.size() > 0) {
            Nodes nodes = pq.poll();
            // Elements are stored in the below form
            // 0 ---> (2, 2), (4, 3) etc.
            // i.e. v1 ---> (v2, w), where v1, v2 are vertices and w is weight
            for(Nodes ele : adj.get(nodes.getVertex())) {
                if((distance[nodes.getVertex()] + ele.getWeight()) < distance[ele.getVertex()]) { // modify distance
                    distance[ele.getVertex()] = distance[nodes.getVertex()] + ele.getWeight();
                    pq.add(new Nodes(ele.getVertex(), distance[ele.getVertex()]));
                }
            }
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
