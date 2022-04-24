import java.util.ArrayList;
import java.util.HashMap;

public class PairWithGivenDifference {
    // TC = O(n^2), AS = O(1)
    public int solve(ArrayList<Integer> A, int B) {
        for(int i = 0; i <= A.size()-2; i++) {
            for(int j = i + 1; j <= A.size()-1; j++) {
                if((A.get(i) - A.get(j)) == B || (A.get(j) - A.get(i)) == B)
                    return 1;
            }
        }
        return 0;
    }

    // TC = O(n), AS = O(n)
    public int solve1(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            int count = hmap.containsKey(A.get(i)) ? hmap.get(A.get(i)) : 0;
            hmap.put(A.get(i), count + 1);
        }

        if(B == 0) {
            for(int key : hmap.keySet())
                if(hmap.get(key) > 1)
                    return 1;
            return 0;
        }

        for (int i = 0; i < A.size(); i++) {
            int ele = B + A.get(i);
            if(hmap.containsKey(ele))
                return 1;
        }
        return 0;
    }
}