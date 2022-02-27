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
}
