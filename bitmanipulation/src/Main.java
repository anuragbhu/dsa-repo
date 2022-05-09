import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = 10;
        // We need to find a bit at 3rd position (0-based indexing) from right.
        int pos =  sc.nextInt();
        int mask = 1 << pos;

        System.out.println((nums & mask) != 0);

        // Now, lets set the bit at particular position.
        nums = nums | mask;
        System.out.println(nums);

        // Now lets clear the bit
        mask = ~ (1 << pos);
        nums = nums & mask;
        System.out.println(mask);
        System.out.println(nums);

        sc.close();
    }
}
