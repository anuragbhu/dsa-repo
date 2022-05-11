import java.util.Arrays;

public class PermutationInString {
    // TC = O(n), AS = (2 * 26) = O(1)
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length(); // Window Size
        int n = s2.length(); // String size

        if(n < k) return false;

        int[] freqS2 = new int[26]; // String
        int[] freqS1 = new int[26]; // Pattern

        for(int i = 0; i < k; i++) {
            freqS2[s2.charAt(i) - 'a']++;
            freqS1[s1.charAt(i) - 'a']++;
        }

        int start = 0, end = s1.length();

        if(Arrays.equals(freqS2, freqS1))
            return true;

        while(end < n) {
            freqS2[s2.charAt(start) - 'a']--;
            freqS2[s2.charAt(end) - 'a']++;

            if(Arrays.equals(freqS2, freqS1))
                return true;

            start++;
            end++;
        }
        return false;
    }
}
