import java.util.Scanner;

// Time Complexity with Union by rank and Path Compression is Constant.
// Time Complexity is the Amortized Time Complexity
// Space Complexity: O(n) + O(n)
// where m is no. of times union called (operations) and n is no. of nodes.

/*
    By combining the union by rank and path compression techniques, we’ll be able to execute each query in nearly
    constant time. We can say that the final amortized time complexity of the DSU is O(α(n)), where α(n) is the inverse
    Ackermann function, which grows very slowly. We can approximate that, α(n) = O(1).
*/

public class DisjointSetOptimize2Final { // Path Compression is done in find fn and Union by rank done in union function
    static int[] parent;
    static int[] rank; // height of tree.

    public static void initialize() {
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1; // considering height by counting number of nodes.
        }
    }

    public static int find(int x) {
        if(parent[x] == x) // Return where parent value and index becomes same. i.e. where node is parent of itself.
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union( int x, int y) {
        // First checking whether parents (representative) of both node is same or not?
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep) {
            return;
        }
        // If representative are not same.
        // Here we are making representative of second item as of child of representative of first time.
        if(rank[x_rep] < rank[y_rep]) parent[x_rep] = y_rep;
        else if(rank[y_rep] < rank[x_rep]) parent[y_rep] = x_rep;
        else { // when rank are same.
            parent[y_rep] = x_rep; // It is wrong .... parent[y] = x; example = union(0,3)
            rank[x_rep]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of nodes // n = 4 assume
        parent = new int[n];
        rank = new int[n];

        initialize(); // Initializing the array

        union(2,3);
        union(1,2);

        System.out.println(find(0));
        System.out.println(find(3));
    }
}
