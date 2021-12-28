import java.util.ArrayList;

public class Flip {
    public ArrayList<Integer> flip(String A) {

        int maxCount = 0, indexL = -1, indexR = -1;
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < A.length(); i++) {
            int count0 = 0, count1 = 0;
            for(int j = i; j < A.length(); j++) {
                if(A.charAt(j) == '0') {
                    count0++;
                } else if(A.charAt(j) == '1') {
                    count1++;
                }

                int count = count0 - count1;

                if (count > maxCount) {
                    maxCount = count;
                    indexL = i+1;
                    indexR = j+1;
                }
            }
        }

        if(indexL == -1 && indexR == -1)
            return res;

        res.add(indexL);
        res.add(indexR);
        return res;
    }


}
