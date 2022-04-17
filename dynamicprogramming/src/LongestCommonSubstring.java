public class LongestCommonSubstring {
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n + 1][m + 1];

        // Initialization Step
        // Initialize first row and first column equal to zero (Not needed in Java).
        int max_v = 0; // To get the maximum common string.
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max_v = Math.max(max_v, dp[i][j]); // getting maximum at each step.
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max_v;
    }
}
