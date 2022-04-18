public class LongestPalindromicSubsequence {
    public int longestPalinSubseq(String S) {
        // Input --- Problem/Question --- Output ---> Total 3 Parts
        // Match current problem with main problem
        // If 2/3 parts match found ---> Then current problem is variation of Main Problem

        // LPS === LCS(A, Reverse(A))

        String T = "";
        for(int i = S.length()-1; i >= 0; i--) {
            T += S.charAt(i);
        }

        return longestCommonSubsequence(S, T);
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
