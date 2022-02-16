import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A.size() == 1) {
            res.add(A.get(0));
            return res;
        }

        for(int i = 0; i < A.size()-B+1; i++) {
            int max = A.get(i);
            for(int j = i; j < (i + B); j++) {
                max = Math.max(max, A.get(j));
            }
            res.add(max);
        }

        return res;
    }
}
