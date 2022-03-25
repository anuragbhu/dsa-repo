import java.util.HashSet;
import java.util.List;

public class WordBreak {
    // SC = O(wordDict.size()) [Ignoring stack used in recursion], TC = Exponential/Factorial
    public boolean wordBreak(int j, String s, HashSet<String> hs) {

        if(s.length() == j) return true;

        String str = "";
        for(int i = j; i < s.length(); i++) {
            str += s.charAt(i);
            if(hs.contains(str)) {
                if(wordBreak(i+1, s, hs)) return true; // Checking for Substring
            }
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // Storing dictionary in the HashSet
        HashSet<String> hs = new HashSet<>();
        for(String str : wordDict)
            hs.add(str);

        return wordBreak(0, s, hs);
    }
}
