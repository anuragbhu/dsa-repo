import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // TC = O(n), AS = O(n)
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, size = 0;
        Set<Character> set = new HashSet<>();

        while(end < s.length()) {
            char ch = s.charAt(end);
            if(!set.contains(ch)) {
                set.add(ch);
            } else {
                while(set.contains(ch)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(ch);
            }
            size = Math.max(size, end - start + 1);
            end++;
        }
        return size;
    }
}
