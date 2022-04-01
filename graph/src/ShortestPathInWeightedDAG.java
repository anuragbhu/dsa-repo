import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Pair {
    int vertex;
    int weight;
    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }
}

public class ShortestPathInWeightedDAG {
    public static void topoSort(int V, ArrayList<ArrayList<Pair>> adj, int src, int[] distance) {

        Stack<Integer> stack = new Stack<>(); // LIFO property use
        dfTraversal(V, adj, stack);

        distance[src] = 0;
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(distance[node] != Integer.MAX_VALUE) { // It means that we have reached this node.
                for(Pair pair : adj.get(node)) {
                    if((distance[node] + pair.getWeight()) < distance[pair.getVertex()]) { // Condition to modify distance
                        distance[pair.getVertex()] = distance[node] + pair.getWeight();
                    }
                }
            }
        }
    }

    public static void dfTraversal(ArrayList<ArrayList<Pair>> adj, int currentVertex, boolean[] visited, Stack<Integer> stack) {
        visited[currentVertex] = true;
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i).getVertex();
            if(!visited[node])  {
                dfTraversal(adj, node, visited, stack);
            }
        }
        stack.push(currentVertex); // add vertex at the end of DFS call.
    }

    public static void dfTraversal(int V, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfTraversal(adj, i, visited, stack);
            }
        }
    }

    private static void addEdge(ArrayList<ArrayList<Pair>> adjList, int v1, int v2, int w) {
        adjList.get(v1).add(new Pair(v2, w));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Vertices
        int e = sc.nextInt(); // Number of Edges

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(n);

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
        topoSort(n, adj, src, distance);

        for (int i = 0; i < n; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println("Shortest distance between source vertex " + src + " to destination vertex " + i +
                    " is:" + " " + distance[i]);
        }
    }
}
