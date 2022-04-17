public class PrintingLongestCommonSubsequence {
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

        int i = n, j = m;
        String temp = "";

        while(i > 0 && j > 0) {
            if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                temp += text1.charAt(i - 1); // When both character are equal
                i--;
                j--;
            } else if(dp[i][j-1] > dp[i-1][j]) { // When both character are not equal
                j--;
            } else {
                i--;
            }
        }

        String ans = "";
        for(int k = temp.length()-1; k >= 0; k--) {
            ans += temp.charAt(k);
        }

        System.out.println(ans);

        return dp[n][m];
    }
}
