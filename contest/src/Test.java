import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(cellsInRange("K1:L2"));
        sc.close();
    }

    public static List<String> cellsInRange(String s) {

        List<String> res = new ArrayList<String>();
        // String[] str = title.split(":");
//        int r1 = s.charAt(1);
//        int r2 = s.charAt(4);
//        char c1 = s.charAt(0);
//        char c2 = s.charAt(3);

        String c1Str = s.substring(0,1);
        char c1 = c1Str.charAt(0);

        String r1Str = s.substring(1,2);
        int r1 = Integer.parseInt(r1Str);

        String c2Str = s.substring(3,4);
        char c2 = c2Str.charAt(0);

        String r2Str = s.substring(4,5);
        int r2 = Integer.parseInt(r2Str);

        while(c1 <= c2) {

            String ans = "";
            int temp = r1;
            while(temp <= r2) {
                String ss =String.valueOf(temp);
                ans += c1 + ss;
                res.add(ans);
                ans = "";
                temp++;
            }
            c1++;

        }


        return res;
    }
}
