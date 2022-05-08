public class MatrixAddition {
    // Time Complexity: O(n * m), Auxiliary Space: O(n * m)
    public void  Addition(int[][] matrixA, int[][] matrixB)
    {
        for(int i = 0 ; i < matrixA.length; i++) {
            for(int j = 0; j < matrixA[i].length; j++) {
                matrixA[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }
}
