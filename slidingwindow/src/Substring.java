public class Substring {
    // TC = O(n^2), AS = (1)
    public static void main(String[] args) {
        String str = "HOME";
        int len = str.length();

        System.out.println("All Non-empty Substrings");
        for(int i = 0; i < len; i++) {
            String ans = "";
            for(int j = i; j < len; j++) {
                ans += str.charAt(j);
                System.out.println(ans);
            }
        }
    }
}
