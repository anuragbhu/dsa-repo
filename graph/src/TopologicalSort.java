import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    //Function to return list containing vertices in Topological order.
    // There can be many topilogical sort.
    // Using DFS: Time Complexity: O(V+E) Space Complexity: O(V+E) to store the adjacency list +
    // O(V) to store the color array + O(V) for auxiliary space of the recursion +
    // O(V) to store in stack
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] topo = new int[V];

        Stack<Integer> stack = new Stack<>();
        dfTraversal(V, adj, stack);

        int index = 0;
        while(!stack.isEmpty()) {
            topo[index] = stack.pop();
            index++;
        }

        return topo;
    }

    public static void dfTraversal(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited, Stack<Integer> stack) {
        visited[currentVertex] = true;
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i);
            if(!visited[node])  {
                dfTraversal(adj, node, visited, stack);
            }
        }
        stack.push(currentVertex);
    }

    public static void dfTraversal(int V, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfTraversal(adj, i, visited, stack);
            }
        }
    }
}
