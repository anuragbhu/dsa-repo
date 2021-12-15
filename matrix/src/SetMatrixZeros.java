import java.util.ArrayList;

public class SetMatrixZeros {
    public void setZeroes1(ArrayList<ArrayList<Integer>> a) {

        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < a.get(i).size(); j++) {
                if(a.get(i).get(j) == 0) {
                    for(int k = 0; k < a.size(); k++) { // col
                        if(a.get(k).get(j) != 0)
                            a.get(k).set(j, -1);
                    }
                    for(int k = 0; k < a.get(i).size(); k++) { // row
                        if(a.get(i).get(k) != 0)
                            a.get(i).set(k, -1);
                    }
                }
            }
        }

        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < a.get(i).size(); j++) {
                if(a.get(i).get(j) == -1) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }
}
