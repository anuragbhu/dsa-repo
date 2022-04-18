public class LongestRepeatingSubsequence {
    public int longestRepeatingSubsequence(String str) {

        // Using same string for row and column
        // Ignore same characters present at same index on both the strings.

        int n = str.length(); // Length of first String "str"
        int m = str.length(); // Length of second String "str"

        int[][] dp = new int[n + 1][m + 1];

        // Initialization Step
        // Initialize first row and first column equal to zero (Not needed in Java).

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) { // change is i != j
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
