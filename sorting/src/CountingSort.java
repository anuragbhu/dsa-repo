public class CountingSort {
    // TC = O(str.length + frequency.length), AS = O(frequency.length)
    public static String countSort(String arr) {
        int[] frequency = new int[26];
        for(int i = 0; i < arr.length(); i++) {
            int val = arr.charAt(i) - 'a';
            frequency[val]++;
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < frequency.length; i++) {
            int j = 0;
            while(j < frequency[i]) {
                char ch = (char) ('a' + i);
                res.append(ch);
                j++;
            }
        }
        return res.toString();
    }
}
