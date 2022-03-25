public class AutoComplete {
    public static void main(String[] args) {
        Trie t = new Trie();
//        String[] arr = {"this", "no", "not", "nor", "note", "notes", "name", "noted", "node"};
        String[] arr ={"dypmhg"};
        String pattern = "no";
//        String pattern = "dypmhg";

//        System.out.println(t.findWord("ni")); // null
//        System.out.println(t.findWord("no")); // TrieNode Address

        autoComplete(t, arr, pattern);
    }

    // T.C. = O(n * l) for insertion; where n = number of words inserted and l = length of the longest word inserted.
    // + O(length of the longest word found for the pattern - pattern length) * 26;
    public static void autoComplete(Trie t ,String[] arr, String pattern) {
        for(String str : arr) {
            t.add(str);
        }
        TrieNode node = t.findWord(pattern); // Here we get the node of last pattern character if present.
        if(node == null) {
            return;
        }
        String output = "";
        allRootToLeafPaths(node, output, pattern);
    }

    private static void allRootToLeafPaths(TrieNode node, String output, String pattern) {
        if(node.childCount == 0) { // For node which is the terminating node whose child count is  = 0 (leaf)
            if(output.length() > 0) {
                System.out.println(pattern + output);
                return;
            }
        }

        if(node.isTerminating) { // For node which is the terminating node whose child count is  > 0
            System.out.println(pattern + output);
        }

        // Iterating through all the characters of each node children
        for(int i = 0; i < node.children.length; i++) {
            if(node.children[i] != null) {
                String ans = output + node.children[i].data;
                allRootToLeafPaths(node.children[i], ans, pattern);
            }
        }
    }
}
