public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int n = nums.length;

        for (int k : nums) totalSum += k; // Calculating sum of array

        if((totalSum < target) || (totalSum - target) % 2 != 0) return 0;

        int sum = (totalSum - target) / 2; // Count no. of subset whose sum is calculated.

        return countSubsetSum(n, nums, sum);
    }

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
}
