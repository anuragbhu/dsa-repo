public class PrintingShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        // LCS Code

        int n = str1.length(); // Length of first String "text1"
        int m = str2.length(); // Length of second String "text2"

        int[][] dp = new int[n + 1][m + 1];

        // Initialization Step
        // Initialize first row and first column equal to zero (Not needed in Java).

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        // SCS Code

        int i = n, j = m;
        String temp = "";

        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                temp += str1.charAt(i - 1); // When both character are equal
                i--;
                j--;
            } else if(dp[i][j-1] > dp[i-1][j]) { // When both character are not equal
                temp += str2.charAt(j - 1);
                j--;
            } else {
                temp += str1.charAt(i - 1);
                i--;
            }
        }
        // From above, we get either i = 0 or j = 0
        while(i > 0) {
            temp += str1.charAt(i - 1);
            i--;
        }

        while(j > 0) {
            temp += str2.charAt(j - 1);
            j--;
        }


        String ans = "";
        for(int k = temp.length()-1; k >= 0; k--) {
            ans += temp.charAt(k);
        }

        return ans;
    }
}
