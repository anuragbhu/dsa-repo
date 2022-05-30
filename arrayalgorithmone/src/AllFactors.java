import java.util.ArrayList;

public class AllFactors {

    // TC = O(n), AS = O(1)
    public ArrayList<Integer> allFactors2(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= A; i++) {
            if(A % i == 0)
                res.add(i);
        }
        return res;
    }

    // TC = O(sqrt(n)), AS = O(1)
    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(A); i++) {
            if(A % i == 0)
                res.add(i);
        }

        for(int i = res.size()-1; i >= 0; i--) { // to maintain sorting order
            int num = res.get(i);
            if(A/num != num){ // we can't take 1 and sqrt(A) again
                res.add(A/num);
            }
        }
        return res;
    }
}
