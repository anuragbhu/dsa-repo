import java.util.Arrays;

public class ArrayListImpl {
    public static void main(String[] args) {
        // solve Dijkstra's Algorithm for better understanding of multi-level arraylist.
        int[][] dp = new int[1001][1001];
        for (int[] row: dp)
            Arrays.fill(row, -1);
    }
}
