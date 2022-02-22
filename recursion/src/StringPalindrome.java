public class StringPalindrome {

    public static boolean isPalindrome(String str, int len) {
        return reverse(str, len).equals(str);
    }

    public static String reverse(String str, int len) {
        if(len == 0) {
            return Character.toString(str.charAt(len));
        }

        String res = Character.toString(str.charAt(len));
        return res + reverse(str, len-1);
    }

    public static boolean isPalindrome1(String str, int start, int end) {
        if(start > end) {
            return true;
        }

        boolean flag =  (str.charAt(start) == str.charAt(end));

        return flag && isPalindrome1(str, start+1, end-1);
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("abcba", 4));  // length - 1
        System.out.println(isPalindrome1("abcba", 0, 4)); // length - 1
    }
}
