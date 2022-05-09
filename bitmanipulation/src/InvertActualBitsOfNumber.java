import java.util.Scanner;

public class InvertActualBitsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0; // Count of Bits
        int nn = n; // Temp value
        while(nn != 0) {
            nn >>= 1;
            count++;
        }
        // Toggle bits
        for(int i = 0; i < count; i++) {
            n = n ^ (1 << i);
        }

        System.out.println(n);
    }
}
