import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixI {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

        int top = 0, bottom = A.size()-1, left = 0, right = A.get(0).size()-1;
        int direction = 0;
        // 0 == --->, 1 == top to bottom, 2 = <---, 3 == bottom to top

        ArrayList<Integer> result = new ArrayList<Integer>();

        while(top <= bottom && left <= right) {
            if(direction == 0) {
                for(int i = left; i <= right; i++) {
                    result.add(A.get(top).get(i));
                }
                top++;
                direction = 1;
            } else if(direction == 1) {
                for(int i = top; i <= bottom; i++) {
                    result.add(A.get(i).get(right));
                }
                right--;
                direction = 2;
            } else if(direction == 2) {
                for(int i = right; i >= left; i--) {
                    result.add(A.get(bottom).get(i));
                }
                bottom--;
                direction = 3;
            } else if(direction == 3) {
                for(int i = bottom; i >= top; i--) {
                    result.add(A.get(i).get(left));
                }
                left++;
                direction = 0;
            }
        }

        return result;
    }
}
