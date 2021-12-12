import java.util.Scanner;

/*
For n = 5

  *
 ***
*****
 ***
  *

 */

// Row count is always odd.
public class DiamondOfStars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();

        for(int i = 1; i <= (row/2)+1; i++) {
            int curSpace = row/2 + 1 - i;
            int curRow = 2 * i - 1;

            for (int j = 1; j <= curSpace; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= curRow; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
        int temp = 0;
        for(int i = 1; i <= row/2; i++) {
            int curSpace = i;
            int curRow = 2 * (row/2 - temp) - 1;

            for (int j = 1; j <= curSpace; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= curRow; j++) {
                System.out.print("*\t");
            }
            System.out.println();
            temp++;
        }
        scanner.close();
    }
}
