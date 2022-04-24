public class EggDroppingPuzzle {
    static int[][] dp = new int[201][201];

    //Function to find minimum number of attempts needed in
    //order to find the critical floor.
    static int eggDrop(int n, int k) {
        // Threshold Floor / Critical Floor

        for(int[] ele : dp) {
            for(int i = 0; i < ele.length; i++) {
                ele[i] = -1;
            }
        }

        return solve(n, k);
    }

    public static int solve(int n, int k) {
        if(k == 0 || k == 1)
            return k;

        if(n == 1)
            return k;

        if(dp[n][k] != -1) {
            return dp[n][k];
        }
        int low = 0, high = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= k; i++) {

            if(dp[n-1][i-1] != -1) {
                low = dp[n-1][i-1];
            } else {
                low = solve(n-1, i-1);
                dp[n-1][i-1] = low;
            }

            if(dp[n][k-i] != -1) {
                high = dp[n][k-i];
            } else {
                high = solve(n, k-i);
                dp[n][k-i] = high;
            }

            int tempans = 1 + Math.max(low, high);
            min = Math.min(tempans, min);
        }
        return dp[n][k] = min;
    }
}
