import java.util.ArrayList;

public class Flip {
    // TC = O(n^2), AS = O(1)
    public int[] flip(String A) {
        int ansDiff = 0, resLeft = -1, resRight = -1;

        for(int i = 0; i < A.length(); i++) {
            int diff = 0;
            for(int j = i; j < A.length(); j++) {
                if(A.charAt(j) == '0') {
                    diff++;
                } else if(A.charAt(j) == '1') {
                    diff--;
                }

                if (diff > ansDiff) {
                    ansDiff = diff;
                    resLeft = i+1; // Indexing start from 1.
                    resRight = j+1; // Indexing start from 1.
                }
            }
        }

        if(resLeft == -1 && resRight == -1)
            return new int[0];

        int[] res = new int[2];
        res[0] = resLeft;
        res[1] = resRight;

        return res;
    }

    // TC = O(n), AS = O(1)
    public int[] flip1(String A) {
        int diff = 0, left = 0, ansDiff = 0, resLeft = -1, resRight = -1;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0')
                diff++;
            else diff--;

            if(diff > ansDiff) {
                ansDiff = diff;
                resLeft = left + 1; // Indexing start from 1.
                resRight = i + 1; // Indexing start from 1.
            }

            if(diff < 0) {
                diff = 0;
                left = i + 1;
            }
        }
        if(resLeft == -1 && resRight == -1)
            return new int[0];

        int[] res = new int[2];
        res[0] = resLeft;
        res[1] = resRight;

        return res;
    }
}
