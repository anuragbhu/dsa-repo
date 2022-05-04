import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixI {
    // TC = O(n*m), AS = O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int top = 0, bottom = row-1, left = 0, right =col-1;
        int direction = 0;
        // 0 == --->, 1 == top to bottom, 2 = <---, 3 == bottom to top

        List<Integer> result = new ArrayList<>();

        while(top <= bottom && left <= right) {
            if(direction == 0) {
                for(int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                direction = 1;
            } else if(direction == 1) {
                for(int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                direction = 2;
            } else if(direction == 2) {
                for(int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                direction = 3;
            } else if(direction == 3) {
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }
        return result;
    }
}
