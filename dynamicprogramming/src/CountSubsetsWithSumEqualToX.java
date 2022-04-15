public class CountSubsetsWithSumEqualToX {
    public static int countSubsetSum(int N, int[] arr, int sum) {
        int[][] dp = new int[N+1][sum+1];

        // Initialization
        for(int i = 0; i < N+1; i++) {
            dp[i][0] = 1;
        } // apart from first col, all are false

        for(int i = 1; i < N+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                if(arr[i-1] <= j) {
                    // Here, max change to ||
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int N = 6;
        int[] arr = {1, 0, 8, 5, 1, 4};
        int sum = 18;

        System.out.println(countSubsetSum(N, arr, sum));
    }

    // Click on IDE
    public int perfectSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];

        // Initialization
        for(int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        } // apart from first col, all are false

        for(int i = 1; i < n+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                if(arr[i-1] <= j) {
                    // Here, max change to ||
                    dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j]) % 1000000007;;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
