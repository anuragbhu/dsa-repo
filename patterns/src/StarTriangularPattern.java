import java.util.Scanner;

/*
For row = 4
   *
  ***
 *****
*******

 */
public class StarTriangularPattern {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();

        for (int i = 1; i < row; i++) {
            int curSpace = row - i;
            int curRow = 2 * i - 1;
            for (int j = 1; j <= curSpace; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= curRow; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
        scanner.close();


    }
}
