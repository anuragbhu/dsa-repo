import java.util.ArrayList;

public class SpiralOrderMatrixII {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < A; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < A; j++){
                temp.add(0);
            }
            result.add(temp);
        }

        int top = 0, bottom = A-1, left = 0, right = A-1;
        int direction = 0;
        int count = 1;
        // 0 == --->, 1 == top to bottom, 2 = <---, 3 == bottom to top

        while(top <= bottom && left <= right) {
            if(direction == 0) {
                for(int i = left; i <= right; i++) {
                    result.get(top).set(i, count);
                    count++;
                }
                top++;
                direction = 1;
            } else if(direction == 1) {
                for(int i = top; i <= bottom; i++) {
                    result.get(i).set(right, count);
                    count++;
                }
                right--;
                direction = 2;

            } else if(direction == 2) {
                for(int i = right; i >= left; i--) {
                    result.get(bottom).set(i, count);
                    count++;
                }
                bottom--;
                direction = 3;

            } else if(direction == 3) {
                for(int i = bottom; i >= top; i--) {
                    result.get(i).set(left, count);
                    count++;
                }
                left++;
                direction = 0;

            }
        }

        return result;
    }
}
