public class SubsetSumProblem {
    public static Boolean isSubsetSum(int N, int arr[], int sum) {
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
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int N = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 6;

        System.out.println(isSubsetSum(N, arr, sum));
    }
}
