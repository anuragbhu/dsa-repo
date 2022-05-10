import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    // TC = O(n * 2^n), AS = O(1)
    public List<String> AllPossibleStrings(String s) {
        List<String> a = new ArrayList<String>();

        int n = s.length();
        int count = 1 << n;

        for(int i = 0; i < count; i++) {
            String result = "";
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0)
                    result += s.substring(j, j+1);
            }
            if(result.length() > 0)
                a.add(result);

        }

        Collections.sort(a);

        return a;
    }
}
