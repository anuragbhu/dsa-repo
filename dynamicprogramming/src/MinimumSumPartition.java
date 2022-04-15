public class MinimumSumPartition {

    // Brute Force will be using all possible combinations of given array to use.

    public int minDifference(int[] arr, int n) {

        int sum = 0;
        for (int k : arr) sum += k; // Calculating sum of array

        int N = arr.length; // as our DP table will be of size (n+1).

        boolean[][] dp = new boolean[N+1][sum+1];

        // Initialization
        for(int i = 0; i < N+1; i++) {
            dp[i][0] = true;
        } // apart from first col, all are false

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < sum+1; j++) {
                if(arr[i-1] <= j) {
                    // Here, max change to ||
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= sum/2; i++) {

            // subset1 sum --> i
            // subset2 sum ---> sum - i
            // sum - i - i = sum - 2*i

            if(dp[N][i]) {
                min = Math.min(min, sum - 2*i);
            }
        }
        return min;
    }
}
