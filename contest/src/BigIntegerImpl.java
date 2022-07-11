import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(factorial(a));
        impl();
    }

    public static BigInteger factorial(int a) {
        BigInteger ans = new BigInteger("1");
        for(int i = 2; i <= a; i++) {
            BigInteger digit = BigInteger.valueOf(i);
            ans = ans.multiply(digit);
        }
        return ans;
    }

    public static void impl() {
        // Initialization
        BigInteger A = new BigInteger("1");

        String b = "123445";
        BigInteger B = new BigInteger(b);

        int c = 21345;
        BigInteger C = BigInteger.valueOf(c);

        // Operations
        BigInteger D = A.add(B);
        // similarly divide, multiply, remainder, subtract

        if (A.compareTo(B) == 0) {
            System.out.println("A == B");
        } else if(A.compareTo(B) == 1) {
            System.out.println("A > B");
        } else if(A.compareTo(B) == -1) {
            System.out.println("B > A");
        }

        // Conversion
        System.out.println(D.intValue());
        System.out.println(A.longValue());
        System.out.println(B.toString());
    }
}
