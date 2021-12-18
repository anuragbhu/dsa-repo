import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public List<String> AllPossibleStrings(String s) {
        List<String> a = new ArrayList<String>();

        int n = s.length();
        int count = 1 << n;

        for(int i = 0; i < count; i++) {
            String result = "";
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0)
                    result += String.valueOf(s.charAt(j));
            }
            if(result.length() > 0)     // (result != null && !result.trim().isEmpty())
                a.add(result);

        }

        Collections.sort(a);


        return a;
    }
}
