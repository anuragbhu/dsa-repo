import java.util.ArrayList;

public class SearchPattern {
    public static ArrayList<Integer> search(String pat, String S) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == pat.charAt(0)) {
                int j = i, k = 0;
                boolean flag = true;
                String substring = "";
                while(j < S.length() && k < pat.length()) {
                    if(S.charAt(j) != pat.charAt(k)) {
                        flag = false;
                        break;
                    } else {
                        substring += S.charAt(j);
                        j++;
                        k++;
                    }
                }
                if(flag && (substring.equals(pat)))
                    res.add(i+1);
            }
        }
        if(res.size() == 0) {
            res.add(-1);
        }
        return res;
    }

    public static ArrayList<Integer> search1(String pat, String txt) {

        int d = 256; // Number of characters in the input alphabet
        int q = 101; // A prime number
        ArrayList<Integer> result = new ArrayList<Integer>();

        int patternLength = pat.length();
        int textLength = txt.length();
        int i, j;
        int hashPattern = 0; // hash value for pattern
        int hashText = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, patternLength-1)%q"
        for (i = 0; i < patternLength-1; i++)
            h = (h*d)%q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < patternLength; i++)
        {
            hashPattern = (d*hashPattern + pat.charAt(i))%q;
            hashText = (d*hashText + txt.charAt(i))%q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= textLength - patternLength; i++)
        {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if ( hashPattern == hashText )
            {
                /* Check for characters one by one */
                for (j = 0; j < patternLength; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }

                // if hashPattern == hashText and pat[0...patternLength-1] = txt[i, i+1, ...i+patternLength-1]
                if (j == patternLength)
                    result.add(i+1);
            }

            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if ( i < textLength-patternLength )
            {
                hashText = (d*(hashText - txt.charAt(i)*h) + txt.charAt(i+patternLength))%q;

                // We might get negative value of hashText, converting it to positive
                if (hashText < 0)
                    hashText = (hashText + q);
            }
        }

        if(result.size() == 0) {
            result.add(-1);
        }

        return result;
    }

    public static void main(String[] args) {
        String pat = "bat";
        String txt = "batmanandrobinarebat";


       System.out.println(search1(pat, txt));
    }
}
