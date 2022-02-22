public class ReverseString {

    public static String reverse(String str, int len) {
        if(len == 0) {
            return Character.toString(str.charAt(len));
        }

        String res = Character.toString(str.charAt(len));
        return res + reverse(str, len-1);
    }

    public static void main(String[] args) {
        System.out.println(reverse("amazing", 6)); // length - 1
    }
}
