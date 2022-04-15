public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // wt array ---> coin array
        // w ---> amount
        // val ---> ignore (1) ---> In-Case of given one array ignore this.
        int N = coins.length;
        int[][] dp = new int[N+1][amount+1];

        // Initialization first column
        for(int i = 1; i < N+1; i++) {
            dp[i][0] = 0;
        }

        // Initialization first row
        for(int j = 0; j < amount+1; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1; // + 1 for count.
        }

        // Initialization second row due to negative value in first row.
        for(int j = 1; j < amount+1; j++) {
            if(j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1; // + 1 for count.
            }

        }

        for(int i = 2; i < N+1; i++) {
            for(int j = 1; j < amount+1; j++) {
                if(coins[i-1] <= j) {
                    // Here, max change to ||
                    // Where ask for # of ways ----> DO SUM
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]); // + 1 for count.
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (dp[N][amount] != Integer.MAX_VALUE - 1) ? dp[N][amount] : -1;
    }
}
