// We can have multiple classes in a file.
// But, public class must be one, which matches with the name of the file.

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children; // Array of size 26 of class itself.
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26]; // Assuming only lower case letters only. // By default, initialize with null.
        childCount = 0;
    }
}

public class Trie {

    private TrieNode root;
    private int numWords;

    public Trie() {
        // I made the root of my Trie a null character this is a standard/typical approach for building out a Trie
        // it is somewhat arbitrary what the root node is.
        root = new TrieNode('\0'); // root must be null character
        numWords = 0;
    }

    private TrieNode findWord(TrieNode root, String word) {
        if(word.length() == 0) {
            return root;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            // Child is not present
            return null;
        }
        return findWord(child, word.substring(1));
    }
    // Time Complexity = O(L); where, L is the length of the String.
    // return the last node of the character
    public TrieNode findWord(String word) {
        return findWord(root, word);
    }

    private int countPrefix(TrieNode root, String prefix) {
        for(int i = 0; i < prefix.length(); ++i) {
            int childIndex = prefix.charAt(i)-'a';
            if(root.children[childIndex] == null || root.childCount == 0)
                return 0;   // No string with given prefix is present
            root = root.children[childIndex];
        }
        int count = 0;
        TrieNode temp = root;
        int childIndex = prefix.charAt(prefix.length()-1)-'a';
        while(temp.children[childIndex] != null) { // Checking for last repeating character in prefix
            count++;
            temp = temp.children[childIndex];
        }
        return root.childCount + count;
    }

    // TC: O(n*l) where n = number of words inserted in Trie and l = length of longest word inserted in Trie.
    public int countPrefix(String prefix) {
        return countPrefix(root, prefix);
    }

    // Search for prefixes
    // insert("sample")
    // prefixes ---> s, sa, sam, samp, sampl, sample
    private boolean startWith(TrieNode root, String prefix) {
        if(prefix.length() == 0) {
            return true; // If prefix is empty then return true
        }

        int childIndex = prefix.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            // Child is not present
            return false;
        }

        return startWith(child, prefix.substring(1));
    }
    // Time Complexity = O(L); where, L is the length of the String.
    public boolean startsWith(String prefix) {
        return startWith(root, prefix);
    }

    private void remove(TrieNode root, String word) {
        if(word.length() == 0) {
            root.isTerminating = false;
            numWords--;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return;
        }
        remove(child, word.substring(1));
        // After recursive call
        // We can remove child node only if it is non-terminating and its number of children are 0.
        // Memory Optimization
        if(!child.isTerminating && child.childCount == 0) {
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
    }
    // Time Complexity = O(L); where, L is the length of the String.
    public void remove(String word) { // As we don't want to pass TrieNode root.
        remove(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.length() == 0) {
            return root.isTerminating;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            // Child is not present
            return false;
        }
        return search(child, word.substring(1));
    }
    // Time Complexity = O(L); where, L is the length of the String.
    public boolean search(String word) {
        return search(root, word);
    }

    private void add(TrieNode root, String word) {
        if(word.length() == 0) { // word: "" ---> Empty String
            root.isTerminating = true;
            numWords++;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        // set root/current node equal to the child
        add(child, word.substring(1));
    }
    // Time Complexity = O(L); where, L is the length of the String.
    public void add(String word) {
        add(root, word);
    }

    public int countWords() {
        return numWords;
    }
}
