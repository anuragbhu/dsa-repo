import java.util.Scanner;

// Time Complexity: O(n) for both find() and union() methods.
// Space Complexity: O(n) + O(n)
public class DisjointSet {

    static int[] parent;

    public static void initialize() {
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if(parent[x] == x) // Return where parent value and index becomes same. i.e. where node is parent of itself.
            return x;
        else
            return find(parent[x]);
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
        parent[y_rep] = x_rep; // It is wrong .... parent[y] = x; example = union(0,3)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of nodes // n = 4 assume
        parent = new int[n];

        initialize(); // Initializing the array

        union(2,3);
        union(1,2);

        System.out.println(find(0));
        System.out.println(find(3));
    }
}
