import java.util.Scanner;

/*

For n = 10

*
*	1	*
*	1	2	1	*
*	1	2	3	2	1	*
*	1	2	3	4	3	2	1	*
*	1	2	3	4	5	4	3	2	1	*
*	1	2	3	4	5	6	5	4	3	2	1	*
*	1	2	3	4	5	6	7	6	5	4	3	2	1	*
*	1	2	3	4	5	6	7	8	7	6	5	4	3	2	1	*
*	1	2	3	4	5	6	7	8	9	8	7	6	5	4	3	2	1	*
*	1	2	3	4	5	6	7	8	9	10	9	8	7	6	5	4	3	2	1	*
*	1	2	3	4	5	6	7	8	9	8	7	6	5	4	3	2	1	*
*	1	2	3	4	5	6	7	8	7	6	5	4	3	2	1	*
*	1	2	3	4	5	6	7	6	5	4	3	2	1	*
*	1	2	3	4	5	6	5	4	3	2	1	*
*	1	2	3	4	5	4	3	2	1	*
*	1	2	3	4	3	2	1	*
*	1	2	3	2	1	*
*	1	2	1	*
*	1	*
*

 */


public class HalfDiamond {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();

        System.out.println("*");
        for(int i = 1; i <= row; i++) {

            System.out.print("*\t");
            // Increasing
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            // Decreasing
            for (int j = i-1; j >= 1; j--) {
                System.out.print(j + "\t");
            }
            System.out.println("*");
        }
        for(int i = row-1; i >= 1; i--) {

            System.out.print("*\t");
            // Increasing
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            // Decreasing
            for (int j = i-1; j >= 1; j--) {
                System.out.print(j + "\t");
            }
            System.out.println("*");
        }
        System.out.println("*");
        scanner.close();
    }
}
