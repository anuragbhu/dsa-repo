public class Conversion {
    public static void main(String[] args) {

        // String to int
        String str = "200";
        int i = Integer.parseInt(str); // Output: 200 ---> // methods throw NumberFormatException.
        Integer in = Integer.valueOf(str); // Output: 200 ---> // methods throw NumberFormatException.

        // int to String
        String s = String.valueOf(i); // Output: "200"
        String ss = Integer.toString(i); // Output: "200"
        String ssss = 0 + " " + 1;

        // char to int
        char ch = '1';
        int a = ch; // Output: 49 (ASCII VALUE)
        int aa = Character.getNumericValue(ch); // Output: 1
        int aaa = Integer.parseInt(String.valueOf(ch)); // Output: 1

        // int to char
        char c = (char) a; // Input: 49 (ASCII VALUE) to Output: '1'
        int aInt = '1';
        char cc = (char)aInt; // // Input: 1 to Output: '1'

        // String to char
        String sss = "hello";
        char cChar = sss.charAt(0); //returns h

        String c1Str = s.substring(0,1);
        char c1 = c1Str.charAt(0); //returns h

        // char to String
        String stringC = String.valueOf(cChar); //returns h
        String sChar = Character.toString(cChar); //returns h

        // String to char Array
        char[] cArray = sss.toCharArray();

        // char Array to String
        char[] chArray = {'w', 'e', 'l', 'c', 'o', 'm', 'e', ' ' , 't', 'o', ' ', 'J', 'a', 'v', 'a'};
        String string1 = new String(chArray);
    }
}
