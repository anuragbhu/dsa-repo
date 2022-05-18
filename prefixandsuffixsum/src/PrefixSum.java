import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        System.out.println("Sum till " + 0 + " index is " + prefixSum[0]);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            System.out.println("Sum till " + i + " index is " + prefixSum[i]);
        }
    }
}
