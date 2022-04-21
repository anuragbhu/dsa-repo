public class PalindromicPatitioning {
    static int[][] dp = new int[501][501]; // 1 ≤ length of str ≤ 500

    static int palindromicPartition(String str) {
        // Find the minimum number of Palindrome Partitioning

        int N = str.length();

        for(int[] ele : dp) {
            for(int i = 0; i < ele.length; i++) {
                ele[i] = -1;
            }
        }
        return minCuts(str, 0, N-1);
    }

    public static int minCuts(String str, int i, int j) {
        // For string size of zero (i > j) and size of one (i == j)
        // The number of palindrome partition needed is 0
        if(i >= j)
            return dp[i][j] = 0;

        // Check for String is Palindrome or not.
        if(isPalindrome(str, i, j))
            return dp[i][j] = 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j-1; k++) {

            int right,left;
            if(dp[i][k] != -1)
                left = dp[i][k];
            else
                left = minCuts(str, i, k);
            dp[i][k] = left;

            if(dp[k+1][j] != -1)
                right = dp[k+1][j];
            else
                right = minCuts(str, k+1, j);
            dp[k+1][j] = right;

            int tempans = left + right + 1;
            // '1' because we already performing one cut by dividing it.
            min = Math.min(tempans, min);
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrome(String str, int i, int j) {

        while(i < j) {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
