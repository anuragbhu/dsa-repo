import java.util.Scanner;

/*
For n = 4

                        1
				2	3	2
		3	4	5	4	3
4	5	6	7	6	5	4

 */

public class TriangleOfNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();

        for(int i = 1; i <= row; i++) {
            int curSpace = 2 * (row - i);
            int curRow = 2 * i - 1;

            for (int j = 1; j <= curSpace; j++) {
                System.out.print("\t");
            }
            int temp = i; // Increasing
            for (int j = 1; j <= (curRow/2)+1; j++) {
                System.out.print(temp + "\t");
                temp++;
            }
            temp -= 2; // Decreasing
            for (int j = 1; j <= (curRow/2); j++) {
                System.out.print(temp + "\t");
                temp--;
            }
            System.out.println();
        }
        scanner.close();
    }
}
