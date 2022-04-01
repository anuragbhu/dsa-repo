import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    //Function to return list containing vertices in Topological order.
    // There can be many topological sort.
    // Using DFS: Time Complexity: O(V+E) Space Complexity: O(V+E) to store the adjacency list +
    // O(V) to store int the visited array + O(V) for auxiliary space of the recursion +
    // O(V) to store in stack
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] topo = new int[V]; // topo array containing all the vertices.

        Stack<Integer> stack = new Stack<>(); // LIFO property use
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
        stack.push(currentVertex); // add vertex at the end of DFS call.
    }

    public static void dfTraversal(int V, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfTraversal(adj, i, visited, stack);
            }
        }
    }

    // Kahn's Algorithm
    //Function to return list containing vertices in Topological order.
    static int[] topoSort1(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] topo = new int[V]; // for storing topo-sorted vertices.
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++) { // Logic for storing the in-degree of the vertices.
            for(int ele : adj.get(i)) {
                indegree[ele]++;
            }
        }

        Queue<Integer> pendingVertices = new LinkedList<>();

        for(int i = 0; i < V; i++) { // Adding vertices having in-degree as 0.
            if(indegree[i] == 0) {
                pendingVertices.add(i);
            }
        }
        int index = 0; // Use to add values in topo array.
        while(!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();
            topo[index] = front;
            index++;
            for(int ele : adj.get(front)) {
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    pendingVertices.add(ele);
                }
            }
        }
        return topo;
    }
}
