import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        int length = 0;

        if(s.length() == 1)
            return 1;

        for(int i = 0; i < s.length(); i++) {

            HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
            boolean distinctFlag = false;
            int j = 0;

            for(j = i; j < s.length(); j++) {
                Integer value = hmap.get(s.charAt(j));
                if (value != null) {
                    int tempLength = j - i;
                    length = Math.max(length, tempLength);
                    distinctFlag = true;
                    break;
                } else {
                    // int count = hmap.containsKey(s.charAt(j)) ? hmap.get(s.charAt(j)) : 0;
                    // hmap.put(s.charAt(j), count + 1);
                    hmap.put(s.charAt(j), 1);
                }
            }

            if(!distinctFlag) {
                int tempLength = j - i;
                length = Math.max(length, tempLength);
            }

        }

        return length;

    }
}
