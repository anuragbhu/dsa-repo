import java.io.*;
import java.util.*;

public class MatrixMultiplication{

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int[][] arr = new int[r1][c1];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[][] brr = new int[r2][c2];

        for(int i = 0; i < brr.length; i++) {
            for(int j = 0; j < brr[0].length; j++) {
                brr[i][j] = sc.nextInt();
            }
        }


        if(c1 != r2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] crr = new int[r1][c2];

        // The complexity of multiplication operation (A*B) is O(m*n*p) where m*n and n*p are order of A and B.
        for(int i = 0; i < crr.length; i++) {
            for(int j = 0; j < crr[0].length; j++) {
                for(int k = 0; k < c1; k++) { // we may use c1 or r2 (the common one)
                    crr[i][j] += arr[i][k] * brr[k][j];
                }
            }
        }

        for(int i = 0; i < crr.length; i++) {
            for(int j = 0; j < crr[0].length; j++) {
                System.out.print(crr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

    }

}