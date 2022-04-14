public class PartitionEqualSubsetSum {
    // Equal Sum partition can only be applied for the array whose sum is even. <--- Step 1.
    // Step 2 for even ---> Now we need to find one partition whose sum /= 2;

    public static Boolean isSubsetSum(int N, int[] arr, int sum) {
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

    public static int equalPartition(int N, int[] arr) {
        int sum = 0;
        for(int ele : arr) {
           sum += ele;
        }

        if(sum % 2 != 0) {
            return 0;
        }

        boolean flag = isSubsetSum(N, arr, sum/2);

        if(flag) return 1;

        return 0;
    }
}
