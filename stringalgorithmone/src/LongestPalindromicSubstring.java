public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int len = 0;
        String ans = "";

        for(int i = 0; i < s.length(); i++) {
            String subString = "";
            for(int j = i; j < s.length(); j++) {
                subString += s.charAt(j);
                boolean flag = isPalindrome(subString);
                int flagLen = subString.length();

                if(flag && (flagLen > len)) {
                    ans = subString;
                    len = flagLen;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String temp) {

        int i = 0, j = temp.length()-1;
        while(i < j) {
            if(temp.charAt(i) != temp.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
