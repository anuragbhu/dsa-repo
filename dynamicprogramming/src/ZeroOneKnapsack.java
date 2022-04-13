import java.util.ArrayList;
import java.util.Arrays;

public class ZeroOneKnapsack {
    // A ---> values
    // B ---> weights
    // C ---> knapsack capacity

    static int[][] dp = new int[1001][1001]; // Contraint se maximum size lena hai

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
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
}
