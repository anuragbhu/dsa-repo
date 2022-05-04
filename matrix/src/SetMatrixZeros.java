import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    // TC = O((n*m)*(n+m)), AS = O(n*m)
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dummy = new int[row][column];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(matrix[i][j] == 0)
                    set(dummy, row, column, i, j);
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(dummy[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }

    public static void set(int[][] dummy, int row, int column, int i, int j) {
        for(int k = 0; k < column; k++) {
            dummy[i][k] = -1;
        }

        for(int k = 0; k < row; k++) {
            dummy[k][j] = -1;
        }
    }

    // TC = O(n*m), AS = O(n+m)
    public void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        Set<Integer> ro = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(matrix[i][j] == 0) {
                    ro.add(i);
                    col.add(j);
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(ro.contains(i) || col.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
    // TC = O(n*m), AS = O(1)
    public void setZeroes3(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        boolean firstRow = false, firstCol = false; // for 1st row and column

        // 1st row
        for(int j = 0; j < column; j++) {
            if(matrix[0][j] == 0)
                firstRow = true;
        }
        //1st column
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == 0)
                firstCol = true;
        }

        // inner matrix leaving 1st row and column
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // filling 0 corresponding to each 0 in row 1 and column 1
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // for 1st row
        if(firstRow) {
            for(int j = 0; j < column; j++)
                matrix[0][j] = 0;

        }

        //for 1st column
        if(firstCol) {
            for(int i = 0; i < row; i++)
                matrix[i][0] = 0;

        }
    }
}
