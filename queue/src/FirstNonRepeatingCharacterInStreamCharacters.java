import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        System.out.println(solve("abcabc"));
    }
}
