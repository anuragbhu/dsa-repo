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
        int a = ch; // Output: 49 (ASCII VALUE) --- > ASCII range: 0 to 255
        int aa = Character.getNumericValue(ch); // Output: 1
        int aaa = Integer.parseInt(String.valueOf(ch)); // Output: 1

        // int to char
        char c = (char) a; // Input: 49 (ASCII VALUE) to Output: '1'
        int aInt = 1;
        char cc = (char) (aInt + '0'); // // Input: 1 to Output: '1'

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

        // Char to ASCII
        // For char to String append only. Not for String to String append (Here we can use String concat).
        StringBuilder str5 = new StringBuilder(); // In place of String str5 = "";
        for(int ii = 0; ii < s.length(); ii++) {
            int ascii = s.charAt(ii);
            if(ascii >= 65 && ascii <= 90) { // For Upper-Case
                ascii += 32;
                char ch5 = (char) ascii;
                str5.append(ch5); // Only used with String Builder. In place of str5 += ch5;
            } else if(ascii >= 97 && ascii <= 122) { // For Lower-Case
                char ch5 = (char) ascii;
                str5.append(ch5);
            } else if(ascii >= 48 && ascii <= 57) { // For Numeric
                char ch5 = (char) ascii;
                str5.append(ch5);
            }
        }
    }
}
