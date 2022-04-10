import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
Dry Run:
    (Word, Ladder, QueueLength): (hit, 1, 1) ---> (hot, 2, 1) ---> (dot/lot, 3, 2) ---> (dog/log, 4, 2) --->
    (cog, 5, 1)
 */

public class WordLadder {
    // Time Complexity: O(N * L * 26)
    // Space Complexity: O(N) + O(N) (Queue and Set)
    // where, ‘N’ is the number of words in the input wordList, ‘L’ length of the max length word
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Given - All the words in wordList are unique and beginWord != endWord.
        // Given - All the words in wordList are unique.
        // Assuming there is no null string.

        // Use queue to help BFS
        Queue<String> pendingWords = new LinkedList<>();
        pendingWords.add(beginWord);
        int ladder = 0; // Number of Ladder to take
        int queLen = 0; // Queue Length

        // Creating HashSet to find word in const time.
        HashSet<String> words = new HashSet<>();
        for(String ele : wordList) words.add(ele);

        // If end word is not present in the Set then return 0.
        if(!words.contains(endWord)) return 0;

        // Traversing till queue not becomes empty.
        while(!pendingWords.isEmpty()) {
            ladder++; // For each word or group of words added, we count ladder as 1.
            queLen = pendingWords.size();

            // for all words at this level
            for(int i = 0; i < queLen; i++) {
                String word = pendingWords.poll(); // removing ele from front
                char[] arr = word.toCharArray(); // converting to char array

                // traverse current word
                for(int j = 0; j < word.length(); j++) {
                    // store initial character at index j
                    char original = arr[j];
                    String nextWord = "";

                    // change 1 letter at a time from 'a' to 'z'
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;

                        nextWord = String.valueOf(arr);
                        // nextWord = new String(arr);

                        if(nextWord.equals(endWord)) return ladder + 1; // match found

                        if(!words.contains(nextWord)) continue; // skip when does not found the word

                        words.remove(nextWord); // removing word
                        pendingWords.add(nextWord); // adding word in the queue
                    }
                    // reset character at index j for next iterations
                    arr[j] = original;
                }
            }
        }
        return 0;
    }
}
