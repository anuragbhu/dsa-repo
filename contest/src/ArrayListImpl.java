import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListImpl {
    public static void main(String[] args) {
        // solve Dijkstra's Algorithm for better understanding of multi-level arraylist.
        int[][] dp = new int[1001][1001];
        for (int[] row: dp)
            Arrays.fill(row, -1);

        // Arrays equals function

        List<Integer> list = new ArrayList<>();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
            // We can use it.next() only once inside the loop.
        }
    }
}
