import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<String> letterCasePermutation1(String s) {

        int n = s.length();

        HashMap<String, Integer> ans = new HashMap<>();

        int max = 1 << n;

        String str = s.toLowerCase();

        for(int i = 0; i < max ; i++){
            String comb = str;
            for(int j = 0; j < n; j++){
                char ch = str.charAt(j);
                if(ch >= 'a'  && ch <= 'z'){
                    if((i & 1<<j) != 0){
                        ch -= 32;
                        comb = comb.substring(0, j) + ch + comb.substring(j + 1);
                    }
                }
            }
            ans.put(comb, 1);
        }

        for(Map.Entry<String, Integer> entry : ans.entrySet()){
            res.add(entry.getKey());
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> ans = letterCasePermutation1("a1b2");

        for(String temp : ans) {
            System.out.println(temp);
        }
    }
}
