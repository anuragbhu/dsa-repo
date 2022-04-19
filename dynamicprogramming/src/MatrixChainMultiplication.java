public class MatrixChainMultiplication {
    static int[][] dp = new int[101][101]; // as max value of N is 100. (Act as Cache)

    static int matrixMultiplication(int N, int[] arr) {
        /*
        MCM --- Identification and Format
        	> I/P - Array or String
        	> Break given I/P based on k which lies between i (left end) and j (right end).
        	> Calculate temp ans based on (i, k) and (k+1, j). ---> means adding brackets

        	> Main Idea of MCM is to reduce the cost. i.e. Reduce the # of multiplication
        		Cost = O/P row count * common column of A and row of B * O/P column
        	> Array Size = n ---> Number of matrix given = n-1
        	> Steps:
        		> 1. Find value of i and j
        		> 2. Find right Base Case
        		> 3. Move k ---> from  i to j
        */

        for(int[] ele : dp) {
            for(int i = 0; i < ele.length; i++) {
                ele[i] = -1;
            }
        }

        return solve(arr, 1, N-1);
    }

    public static int solve(int[] arr, int i, int j) {
        if(i >= j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j-1; k++) {
            int tempans = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(tempans, min);
        }
        return dp[i][j] = min;
    }
}
