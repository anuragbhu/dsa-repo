public class PrefixSumOfMatrix {

    public static void prefixSumOfMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        // Storing Prefix Sum of Matrix
        int[][] prefixSum = new int[m][n];

        // case 1: for first element of the matrix
        prefixSum[0][0] = arr[0][0];

        int sum = arr[0][0];
        // case 2: For first row of the matrix (except first element)
        for(int j = 1; j < n; j++) {
            sum += arr[0][j];
            prefixSum[0][j] = sum;
        }

        sum = arr[0][0];
        // case 3: For first column of the matrix (except first element)
        for(int i = 1; i < m; i++) {
            sum += arr[i][0];
            prefixSum[i][0] = sum;
        }

        // case 4: For rest of the elements of (m-1)*(n-1)
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i][j];
            }
        }

        // Print Matrix
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(prefixSum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30}, {5, 10, 20}, {2, 4, 6}};
        prefixSumOfMatrix(arr);
    }
}
