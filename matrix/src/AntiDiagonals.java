import java.util.ArrayList;

public class AntiDiagonals {
    // TC = O(n^2), AS = O(1)
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int row = A.size();
        int len = 2*row - 1;

        for(int i = 0; i < len; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            res.add(temp);
        }

        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.get(0).size(); j++) {
                res.get(i+j).add(A.get(i).get(j));
            }
        }

        return res;
    }
}
