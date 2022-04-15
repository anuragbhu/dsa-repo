public class CoinChange2 {
    public int change(int amount, int[] coins) {
        // Sequence: Coin Change II ----> Coin Change I
        // Coin Change II: maximum number of ways that you need to make up that amount.
        // Coin Change I: minimum number of coins that you need to make up that amount.

        // wt array ---> coin array
        // w ---> amount
        // val ---> ignore (1) ---> In-Case of given one array ignore this.
        int N = coins.length;
        int[][] dp = new int[N+1][amount+1];

        // Initialization
        for(int i = 0; i < N+1; i++) {
            dp[i][0] = 1;
        } // apart from first col, all are false

        for(int i = 1; i < N+1; i++) {
            for(int j = 0; j < amount+1; j++) {
                if(coins[i-1] <= j) {
                    // Here, max change to ||
                    // Where ask for # of ways ----> DO SUM
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][amount];
    }
}
