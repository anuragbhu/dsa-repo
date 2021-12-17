import java.io.File;
import java.util.*;

public class Test {

    public static void main(String[] args) {


        reverse(322122547);
    }
//    Integer x = Integer.valueOf(str);
//    // or
//    int y = Integer.parseInt(str);
    public static long reverse(long a) {
        // Autoboxing
        int aa =20;
        Integer i= aa;//converting int into Integer explicitly
        Integer j=aa;//autoboxing, now compiler will write Integer.valueOf(a) internally

        // Unboxing
        Integer aaa = (Integer) 3;
        int ii = aaa;//converting Integer to int explicitly
        int jj = aaa;//unboxing, now compiler will write a.intValue() internally

        String str = "";
        while(a > 0) {
            int temp = (int) a % 10;
            str += Integer.toString(temp);
            a /= 10;
        }
        System.out.println(str);
        System.out.println(Integer.parseInt(str));
        String str1 = String.valueOf(1234);
        return 0;
    }
}