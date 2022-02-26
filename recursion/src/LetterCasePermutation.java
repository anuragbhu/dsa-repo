import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    static int count = 1; // size of output list
    static List<String> res = new ArrayList<>();

    public static List<String> letterCasePermutation(String s) {

        String str = s.toLowerCase();

        res.add(str);

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'a'  && ch <= 'z') {
                // convert to upper case
                ch -= 32;
                add(ch, i);
            }
        }

        return res;
    }

    private static void add(char ch, int pos) {

        int i = 0;
        while(i < count) { // replace that character for whole output list
            String str = res.get(i);
            String newStr = str.substring(0, pos) + ch + str.substring(pos + 1);
            res.add(newStr);
            i++;
        }

        count += count;
    }

    public static void main(String[] args) {
        List<String> ans = letterCasePermutation("ABC");

        for(String temp : ans) {
            System.out.println(temp);
        }
    }
}
