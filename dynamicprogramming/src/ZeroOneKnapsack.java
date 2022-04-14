import java.util.ArrayList;
import java.util.Arrays;

public class ZeroOneKnapsack {
    // A ---> values
    // B ---> weights
    // C ---> knapsack capacity

    static int[][] dp = new int[1001][1001]; // Constraint se maximum size lena hai
    // Create matrix of values that are changing in the recursive step

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        // Initialization of matrix with -1
        for (int[] row: dp)
            Arrays.fill(row, -1);

        int n = A.size();
        return knapSack(A, B, C, n);
    }

    public static int knapSack(ArrayList<Integer> A, ArrayList<Integer> B, int C, int n) {
        if(n == 0 || C == 0) {
            return 0;
        }

        if(dp[n][C] != -1) {
            return dp[n][C];
        }

        if(B.get(n-1) <= C) {
            return dp[n][C] = Math.max(A.get(n-1) + knapSack(A, B, C - B.get(n-1), n-1), knapSack(A, B, C, n-1));
        }

        // else if(B.get(n-1) > C)
        return dp[n][C] = knapSack(A, B, C, n-1);
    }

    public int solve1(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int N = A.size();
        int[][] dp = new int[N+1][C+1]; // Constraint se maximum size lena hai // store sub-problem result
        // Given N = 1000, W = 1000
        // So, consider dp of size (N+1)(W+1)
        // Might be the case where N and W is not equal

        /*
        Memoization - base condition == Tabulation - initialization
        Not needed in java as it already equal to zero.
        for(int i = 0; i < N+1; i++) { // For N
            for(int j = 0; j < C+1; j++) { // For W
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        */

        for(int i = 1; i < N+1; i++) { // For N
            for(int j = 1; j < C+1; j++) { // For W
                if(B.get(i-1) <= j) {
                    dp[i][j] = Math.max(A.get(i-1) + dp[i-1][j-B.get(i-1)], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][C];
    }
}
