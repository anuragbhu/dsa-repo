public class SearchA2DMatrix {
    // TC = O(n*m), SC = O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
    // TC = O(n+m), SC = O(1)
    public boolean searchMatrix1(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;

        int i = 0, j = m-1;

        while(i >= 0 && i < n && j >= 0 && j < m) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
