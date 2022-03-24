public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();

        t.add("ab");
        System.out.println("Count: " + t.countWords());

        t.add("");
        System.out.println("Count: " + t.countWords());

        t.add("news");
        System.out.println("Count: " + t.countWords());

        t.add("new");
        System.out.println("Count: " + t.countWords());

        System.out.println(t.search("news"));
        System.out.println(t.search("bat"));

        t.remove("news");
        System.out.println("Count: " + t.countWords());

        System.out.println(t.search("news"));
        System.out.println(t.search("new"));
        System.out.println(t.startsWith("ne"));
    }
}
