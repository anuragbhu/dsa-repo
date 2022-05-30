public class ReverseString {
    // TC = O(n), AS = O(1)
    public void reverseString(char[] s) {
        int start = 0, end = s.length-1;
        while(start < end) {
            char ch = s[start];
            s[start] = s[end];
            s[end] = ch;
            start++;
            end--;
        }
    }
}
