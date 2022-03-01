import java.util.ArrayList;

public class SubsequencesOfString {
    public static ArrayList<String> subsequences(String s) {
        ArrayList<String> a = new ArrayList<String>();
        int n = s.length();
        int count = 1 << n;

        for(int i = 0; i < count; i++) {
            String result = "";
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0)
                    result += String.valueOf(s.charAt(j));
            }
            if(!result.trim().isEmpty())
                a.add(result);
        }
        return a;
    }

    public static ArrayList<String> subsequences1(String s) {
        ArrayList<String> res = new ArrayList<>();
        generate("", 0, s, res);
        return res;
    }

    public static void generate(String curr, int index, String s, ArrayList<String> res) {

        if(index == s.length()) {
            if(curr.length() != 0)
                res.add(curr);
            return;
        }

        generate(curr, index+1, s, res);

        curr += s.charAt(index);
        generate(curr, index+1, s, res);

        curr = curr.substring(0, curr.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(subsequences1("p"));
        System.out.println(subsequences1("hq"));
        System.out.println(subsequences("ghu"));
    }
}
