import java.util.ArrayList;

public class AllFactors {
    public ArrayList<Integer> allFactors(int A) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A < 1) return res;

        for(int i = 1; i <= Math.sqrt(A); i++) {
            if(A % i == 0) {
                res.add(i);
            }
        }

        for(int i = res.size()-1; i >= 0; i--) {
            int num = res.get(i);
            if(A/num != num) // A = 1
                res.add(A/num);
        }

        return res;
    }
}
