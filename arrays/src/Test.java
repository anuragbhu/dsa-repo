import java.io.File;
import java.util.*;

public class Test {

    public static void main(String[] args) {


        reverse(4294967295l);
    }
//    Integer x = Integer.valueOf(str);
//    // or
//    int y = Integer.parseInt(str);
    public static long reverse(long a) {
//        // Autoboxing
//        int aa =20;
//        Integer i= aa;//converting int into Integer explicitly
//        Integer j=aa;//autoboxing, now compiler will write Integer.valueOf(a) internally
//
//        // Unboxing
//        Integer aaa = (Integer) 3;
//        int ii = aaa;//converting Integer to int explicitly
//        int jj = aaa;//unboxing, now compiler will write a.intValue() internally

//        while(a > 0) {
//            int temp = (int) a % 10;
//            str += Integer.toString(temp);
//            a /= 10;
//        }

        String str = "";
        while(a > 0) {
            long temp = (long) a % 2;
            str += Long.toString(temp);
            System.out.println(str);
            a /= 2;
        }

        int len = 32 - str.length();

        for(int i = 0; i < len; i++) {
            str += "0";
        }

        int pow = 31;
        long res = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            long y = ch - '0';
            res += y * Math.pow(2, pow);
            pow--;
//             System.out.println(res);
        }

        System.out.println(str);
        System.out.println(str.length());
        System.out.println(res);
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Integer.parseInt(str));
//        String str1 = String.valueOf(1234);
        return 0;
    }
}