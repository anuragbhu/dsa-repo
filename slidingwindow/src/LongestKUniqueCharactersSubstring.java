import java.util.HashMap;

public class LongestKUniqueCharactersSubstring {
    // TC = O(n), AS = O(n)
    public int longestkSubstr(String s, int k) {

        if(s.length() < k)
            return -1;

        int start = 0, end = 0, size = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        if(map.size() < k)
            return -1;

        map.clear();

        while(end < s.length()) {

            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size() > k) {
                char del = s.charAt(start);
                if(map.get(del) == 1)
                    map.remove(del);
                else
                    map.put(del, map.get(del) - 1);
                start++;
            }

            size = Math.max(size, end - start + 1);
            end++;
        }
        return size;
    }
}
