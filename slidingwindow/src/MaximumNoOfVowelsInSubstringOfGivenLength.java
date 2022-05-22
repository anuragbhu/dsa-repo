public class MaximumNoOfVowelsInSubstringOfGivenLength {
    private boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    // TC = O(n), AS = O(1)
    public int maxVowels(String s, int k) {
        int count = 0, maxCount = 0;
        int n = s.length();

        if(n == 0 || k == 0 || n < k)
            return 0;

        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i)))
                count++;
        }

        maxCount = Math.max(count, maxCount);

        int start = 0, end = k;

        while(end < n) {
            if(isVowel(s.charAt(start)))
                count--;
            if(isVowel(s.charAt(end)))
                count++;

            start++;
            end++;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
