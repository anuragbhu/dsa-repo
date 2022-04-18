public class MinimumNumberOfDeletionsAndInsertions {
    public int minOperations(String str1, String str2) {

        // # of Deletion = str1.length() - LCS
        // # of Insertion = str2.length() - LCS

        int lcs = longestCommonSubsequence(str1, str2);

        return (str1.length() - lcs) + (str2.length() - lcs);
    }

    public int longestCommonSubsequence(String text1, String text2) {
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
