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

    public ArrayList<Integer> flip1(String a) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        int diff = 0, left = 0, right = 0, ansDiff = 0, resLeft = -1, resRight = -1;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '0')
                diff++;
            else diff--;

            if(diff > ansDiff) {
                ansDiff = diff;
                resLeft = left + 1; // Indexing start from 1.
                resRight = right + 1;
            }

            if(diff < 0) {
                diff = 0;
                left = i + 1;
            }

            right++;
        }
        if(resLeft == -1 && resRight == -1)
            return res;

        res.add(resLeft);
        res.add(resRight);

        return res;
    }


}
