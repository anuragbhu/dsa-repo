import java.util.ArrayList;

public class SpiralOrderMatrixII {
    // TC = O(n*m), AS = O(1)
    public int[][] generateMatrix(int n) {
        // Here row = n and col = n
        int[][] result = new int[n][n];

        int top = 0, bottom = n-1, left = 0, right = n-1;
        int direction = 0;
        int element = 1;
        // 0 == --->, 1 == top to bottom, 2 = <---, 3 == bottom to top

        while(top <= bottom && left <= right) {
            if(direction == 0) {
                for(int i = left; i <= right; i++) {
                    result[top][i] = element;
                    element++;
                }
                top++;
                direction = 1;
            } else if(direction == 1) {
                for(int i = top; i <= bottom; i++) {
                    result[i][right] = element;
                    element++;
                }
                right--;
                direction = 2;

            } else if(direction == 2) {
                for(int i = right; i >= left; i--) {
                    result[bottom][i] = element;
                    element++;
                }
                bottom--;
                direction = 3;

            } else if(direction == 3) {
                for(int i = bottom; i >= top; i--) {
                    result[i][left] = element;
                    element++;
                }
                left++;
                direction = 0;
            }
        }
        return result;
    }
}
