import java.util.ArrayList;

public class RotateMatrix {
    // TC = O(n^2), SC = O(1)
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Transpose
        for(int i = 0; i < row; i++) {
            for(int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse row by row
        for(int i = 0; i < row; i++) {
            int j = 0, k = col-1;
            while(j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;

                j++;
                k--;
            }
        }
    }
}
