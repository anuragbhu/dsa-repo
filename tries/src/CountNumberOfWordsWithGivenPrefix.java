public class CountNumberOfWordsWithGivenPrefix {

    public static void main(String[] args) {
        Trie t = new Trie();

        String[] str = {"apk", "app", "apple", "arp", "array"};
        String pre = "ap";

        insertWords(t, str);
        System.out.println(searchPrefixCount(t, pre));
    }

    public static int searchPrefixCount(Trie t, String pre) {
        return t.countPrefix(pre);
    }

    public static void insertWords(Trie t ,String[] str) {
        for(String ele : str) {
            t.add(ele);
        }
    }
}
