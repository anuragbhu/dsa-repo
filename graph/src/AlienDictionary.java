import java.util.ArrayList;
import java.util.Stack;

/*
Steps:
    1) Construct Graph
    2) Topo Sort

Test cases during construction: ["abc", "abc"], ["abc", "abcd"]
*/

// Time Complexity: O(N * L) + O(C + E)  (Construction and Topo Sort)
// Space Complexity: O(C) + (C) + O(C + E) (Visited Array, Stack, Adjacency List)
// where, ‘N’ is the number of words in the input alien vocabulary/dictionary,
// ‘L’ length of the max length word, and ‘C’ is the final number of unique characters

public class AlienDictionary {
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

    public String findOrder(String [] dict, int N, int K) {

        // Steps 1): Construct Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            // Finding min length of both the string pairs.
            int minLength = Math.min(dict[i].length(), dict[i+1].length());
            for(int j = 0; j < minLength; j++) {
                if(dict[i].charAt(j) != dict[i+1].charAt(j)) { // Checking ch by ch
                    int u = dict[i].charAt(j) - 'a';
                    int v = dict[i+1].charAt(j) - 'a';
                    adj.get(u).add(v);
                    break; // Important to break for further check
                }
            }
        }

        // Step 2): Topo Sort
        Stack<Integer> stack = new Stack<>();
        dfTraversal(K, adj, stack);

        String ans = "";
        while(!stack.isEmpty()) {
            int node = stack.pop();
            char ch = (char) (node + 'a');
            ans += ch;
        }

        return ans;
    }
}
