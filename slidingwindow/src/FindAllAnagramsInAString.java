import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    // TC = O(n), AS = (2 * 26) = O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int k = p.length(); // Window Size
        int n = s.length(); // String size

        if(n < k) return res;

        int[] freqS = new int[26]; // String
        int[] freqP = new int[26]; // Pattern

        for(int i = 0; i < k; i++) {
            freqS[s.charAt(i) - 'a']++;
            freqP[p.charAt(i) - 'a']++;
        }

        int start = 0, end = p.length();

        if(Arrays.equals(freqS, freqP))
            res.add(0);

        while(end < n) {
            freqS[s.charAt(start) - 'a']--;
            freqS[s.charAt(end) - 'a']++;

            if(Arrays.equals(freqS, freqP))
                res.add(start + 1);

            start++;
            end++;
        }
        return res;
    }
}
