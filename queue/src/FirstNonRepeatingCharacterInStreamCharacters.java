import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInStreamCharacters {
    public static String solve(String A) {

        String res = "";

        for(int i = 0; i < A.length(); i++) {
            HashMap<Character, Integer> hmap = new  HashMap<>();
            for(int j = 0; j <= i; j++) {
                if(hmap.containsKey(A.charAt(j))) {
                    Integer val = hmap.get(A.charAt(j));
                    hmap.put(A.charAt(j),  val + 1);
                } else {
                    hmap.put(A.charAt(j), 1);
                }
            }
            boolean flag = false;
            for(int j = 0; j <= i; j++) {
                if(hmap.get(A.charAt(j)) == 1) {
                    res += A.charAt(j);
                    flag = true;
                    break;
                }

            }

            if(!flag)
                res += "#";
        }

        return res;
    }

    public String solve1(String A) {

        // HashMap<Character, Integer> hmap = new HashMap<Character, Integer>(); // TLE
        int[] frequency = new int[26]; // TLE
        Queue<Character> queue = new LinkedList<>();
        String res = "";

        for(int i = 0; i < A.length(); i++) {

            char ch = A.charAt(i);
            int index = ch - 'a';
            frequency[index]++;

            queue.add(ch);
            boolean found = false;

            while(!queue.isEmpty()) {
                char temp = queue.peek();
                int position = temp - 'a';
                if(frequency[position] == 1) {
                    res += temp;
                    found = true;
                    break;
                } else {
                    queue.remove();
                }
            }
            if(!found) {
                res += "#";
            }
        }

        // for(int i = 0; i < A.length(); i++) {
        //     Character ch = A.charAt(i);
        //     if(hmap.containsKey(ch)) {
        //         Integer count = hmap.get(ch);
        //         count++;
        //         hmap.put(ch, count);
        //     } else {
        //         hmap.put(ch, 1);
        //     }

        //     queue.add(ch);

        //     boolean found = false;
        //     while(!queue.isEmpty()) {
        //         char temp = queue.peek();
        //         if(hmap.get(temp) == 1) {
        //             res += temp;
        //             found = true;
        //             break;
        //         } else {
        //             queue.poll();
        //         }
        //     }
        //     if(!found) {
        //         res += "#";
        //     }
        // }
        return res;
    }

    public String solve2(String A) {

        int[] frequency = new int[26]; // TLE
        Queue<Character> queue = new LinkedList<>();
        char[] s = new char[A.length()];

        for(int i = 0; i < A.length(); i++) {

            char ch = A.charAt(i);
            int index = ch - 'a';
            frequency[index]++;

            queue.add(ch);
            boolean found = false;

            while(!queue.isEmpty()) {
                char temp = queue.peek();
                int position = temp - 'a';
                if(frequency[position] == 1) {
                    s[i] = temp;
                    found = true;
                    break;
                } else {
                    queue.remove();
                }
            }
            if(!found) {
                s[i] = '#';
            }
        }

        return new String(s);
    }

    public static void main(String[] args) {
        System.out.println(solve("abcabc"));
    }
}
