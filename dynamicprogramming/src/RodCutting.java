public class RodCutting {

    // wt ---> len
    // val ---> price
    // w ---> rod.length

    public int cutRod(int[] price, int n) {
        // If not given the length array then create it.
        int[] rod = new int[n];
        for(int i = 1; i <= n; i++) {
            rod[i-1] = i;
        }

        int[][] dp = new int[n+1][rod.length+1];

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < rod.length+1; j++) {
                if(rod[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-rod[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rod.length];
    }
}
