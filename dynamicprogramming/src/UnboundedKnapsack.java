public class UnboundedKnapsack {
    static int knapsack(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int[N+1][W+1];

        for(int i = 1; i < N+1; i++) { // For N
            for(int j = 1; j < W+1; j++) { // For W
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]); // dp[i-1] changes to dp[i] for
                    // first parameter
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
}
