public class MinimumNumberOfDeletions {
    int minDeletions(String str, int n) {
        // # of deletions is inversely proportional to length of LPS.
        // i.e. if we find the longest palindromic subsequence than it automatically implies
        // the least number of deletion.
        // i.e. Problem reduces fo LPS

        // Whole idea is to Break down the complex problem to a simple problem.
        // or convert to a variation of the problem already solved.

        String revStr = "";
        for(int i = str.length()-1; i >= 0; i--) {
            revStr += str.charAt(i);
        }

        return n - longestCommonSubsequence(str, revStr); // str.length - LPS

    }

    public static int longestCommonSubsequence(String text1, String text2) {
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
}
