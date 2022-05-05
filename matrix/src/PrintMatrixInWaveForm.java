public class PrintMatrixInWaveForm {
    public static void main(String[] args) {
        int[][] matrix = {{1, 9, 4, 10}, {3, 6, 90, 11}, {2, 30, 85, 72}, {6, 31, 99, 15}};

        int row = matrix.length;
        int col = matrix[0].length;

        for(int j = 0; j < col; j++) {
            if(j % 2 == 0) { // even column --- move down
                for(int i = 0; i < row; i++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else { // odd column --- move up
                for(int i = row-1; i >= 0; i--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
