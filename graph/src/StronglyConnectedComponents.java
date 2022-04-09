import java.util.ArrayList;
import java.util.Stack;

/*
SCC: A strongly connected component is the portion of a directed graph in which there is a path from each vertex to
another vertex.

Kosaraju's Algo
Steps:
    1) Sort all the nodes in order of finishing time. ---- Topological Sort
    2) Transpose the graph --- To avoid going anywhere apart from SCC.
    3) DFS according to the finishing time. i.e. using Topo Sorted.

Application:
    In social networks, a group of people are generally strongly connected (For example, students of a class or any
    other common place). Many people in these groups generally like some common pages or play common games. The SCC
    algorithms can be used to find such groups and suggest the commonly liked pages or games to the people in the
    group who have not yet liked commonly liked a page or played a game.
 */

// Time Complexity: O(V) + O(V+E) + O(V+E) (Step 1, 2, and 3)
// Space Complexity: O(V) + O(V) + O(V+E) (Visited Array, Stack, Transpose Graph)
public class StronglyConnectedComponents {

    public static void revDfs(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
//        System.out.print(currentVertex + " ");
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i);
            if(!visited[node])  {
                revDfs(adj, node, visited);
            }
        }
    }

    public static void dfTraversal(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited, Stack<Integer> stack) {
        visited[currentVertex] = true;
        for(int i = 0; i < adj.get(currentVertex).size(); i++) {
            int node = adj.get(currentVertex).get(i);
            if(!visited[node])  {
                dfTraversal(adj, node, visited, stack);
            }
        }
        stack.push(currentVertex); // add vertex at the end of DFS call.
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        // Sort all the nodes in order of finishing time. ---- Topological Sort
        Stack<Integer> stack = new Stack<>(); // LIFO property use
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfTraversal(adj, i, visited, stack);
            }
        }

        // Transpose the graph --- To avoid going anywhere apart from SCC.
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            visited[i] = false;
            for(Integer it : adj.get(i)) {
                transpose.get(it).add(i);
            }
        }

        // DFS according to the finishing time. i.e. using Topo Sorted.
        int count = 0; // count the number of connected components
        while(!stack.empty()) {
            int node = stack.pop();
            if(!visited[node]) {
//                System.out.print("SCC: ");
                revDfs(transpose, node, visited);
//                System.out.println();
                count++;
            }
        }
        return count;
    }
}
