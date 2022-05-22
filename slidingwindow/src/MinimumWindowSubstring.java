import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();
        // Add characters of S with 0 count
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), 0);
        }
        // Check and add count of characters
        for(int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                return "";
            }
        }

        int start = 0, end = 0; // Sliding Window Technique
        // start --> shrink the window, end --> expand the window
        int targetLen = t.length(); // Required number of characters to be present in substring
        int minLen = Integer.MAX_VALUE; // Minimum length of substring required
        int begin = 0; // For storing the beginning of the index of required substring

        while(end < s.length()) {
            char curr = s.charAt(end);

            if(map.get(curr) > 0)
                targetLen--;

            map.put(curr, map.get(curr)-1);

            // until the window condition is satisfied keep shrinking the window
            while(targetLen == 0) {
                if(minLen > end-start+1) {
                    minLen = end-start+1; // update the minimum length continuously
                    begin = start; // begin index of the answer
                }

                // If less than zero that means still targetLen is 0 because all required characters
                // are still in the window.
                if(map.get(s.charAt(start)) >= 0)
                    targetLen++;

                // Increase frequency of start index.As we are increasing it.
                map.put(s.charAt(start), map.get(s.charAt(start)) + 1);

                start++;
            }
            end++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(begin, begin + minLen);
    }
}
