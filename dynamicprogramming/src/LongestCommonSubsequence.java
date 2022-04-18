public class LongestCommonSubsequence {

    // LongestCommonSubsequence means LCS
    // LongestCommonSubstring doesn't mean LCS
    static int[][] dp; // or we can define based on constraint like if given (1000 * 1000), then initialize with (1001 * 1001);

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(); // Length of first String "text1"
        int m = text2.length(); // Length of second String "text2"

        dp = new int[n + 1][m + 1];

        for (int[] ele : dp)
            for (int i = 0; i < ele.length; i++)
                ele[i] = -1;

        return longestCommonSubsequence(text1, text2, n, m);
    }

    public int longestCommonSubsequence(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return dp[n][m] = 1 + longestCommonSubsequence(text1, text2, n - 1, m - 1);
        } else {
            return dp[n][m] = Math.max(longestCommonSubsequence(text1, text2, n, m - 1), longestCommonSubsequence(text1, text2, n - 1, m));
        }
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int n = text1.length(); // Length of first String "text1"
        int m = text2.length(); // Length of second String "text2"

        int[][] dp = new int[n + 1][m + 1];

        // Initialization Step
        // Initialize first row and first column equal to zero (Not needed in Java).

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

    /*
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(); // Length of first String "text1"
        int m = text2.length(); // Length of second String "text2"

        return longestCommonSubsequence(text1, text2, n, m);
    }

    // Recursive #TLE
    public int longestCommonSubsequence(String text1, String text2, int n, int m) {
        if(n == 0 || m == 0)
            return 0;

        if(text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return 1 + longestCommonSubsequence(text1, text2, n-1, m-1);
        } else {
            return Math.max(longestCommonSubsequence(text1, text2, n, m-1), longestCommonSubsequence(text1, text2, n-1, m));
        }
    }
     */
}
