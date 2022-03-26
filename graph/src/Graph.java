import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    // Implementation of Adjacency List
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Vertices
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);

        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        int e = sc.nextInt(); // Number of Edges
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addEdge(adjList, v1, v2);
        }

        printGraph(adjList);

        sc.close();
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int v1, int v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
