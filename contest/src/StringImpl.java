public class StringImpl {

    public static void main(String[] args) {

        // Converts integer to string
        String temp = Integer.toString(10);
        System.out.println(temp);

        // Zero based indexing
        String myStr = "Hello";

        // Returns the character at the specified index (position) i.e. 'H'
        char result = myStr.charAt(0);

        String myStr1 = "Hi";

        // Appends a string to the end of another string i.e. "HelloHi"
        System.out.println(myStr.concat(myStr1));

        // Checks whether a string contains a sequence of characters i.e. true
        System.out.println(myStr.contains("Hel"));

        String myStr2 = "Another String";

        // Compares two strings. Returns true if the strings are equal, and false if not i.e. false
        // As String is an Object so, we cannot use == sign. Since, it compares address.
        System.out.println(myStr1.equals(myStr2));

        String myStr3 = "HELLO";

        // Compares two strings, ignoring case considerations i.e. true
        System.out.println(myStr.equalsIgnoreCase(myStr3));

        // Converts a string to upper case letters i.e. "HI"
        System.out.println(myStr1.toUpperCase());
        System.out.println(myStr1); // Hi

        // Converts a string to lower case letters i.e. "hi"
        System.out.println(myStr1.toLowerCase());

        String myStr4 = "       Hello World!       ";
        System.out.println(myStr4);

        // Removes whitespace from both ends of a string i.e. "Hello World!"
        System.out.println(myStr4.trim());

        String myStr5 = "";

        // The string is empty (length() is 0) i.e. true
        System.out.println(myStr5.isEmpty());

        // Returns the length of a specified string
        System.out.println(myStr5.length());

        String s = "GeeksforGeeks";

        //  It returns a newly allocated character array.
        char[] gfg = s.toCharArray();

        // String substring(begIndex, endIndex) ; the begin index, inclusive.
        // String substring(int begIndex) ; the end index, exclusive.
        System.out.println(myStr.substring(1, 3));

        String title = "Hello I'm your String";

        // How to split a String by space
        // This will cause any number of consecutive spaces to split your string into tokens.
        // The + (Quantifiers) at the end of the regular-expression,
        // would treat multiple spaces the same as a single space.
        // It returns an array of strings (String[]) without any " " results.
        // \\s+ will split your string on one or more spaces
        String[] str = title.split("\\s+");

        // result =
        // Geeks
        //Geeks
        //Students
        String str1 = "GeeksforGeeksforStudents";
        String[] arrOfStr = str1.split("for");

    }
}
