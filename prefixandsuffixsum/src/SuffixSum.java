import java.util.Scanner;

public class SuffixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] prefixSum = new int[n];
        prefixSum[n-1] = arr[n-1];
        System.out.println("Sum till " + (n-1) + " index is " + prefixSum[n-1]);
        for(int i = n-2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i+1] + arr[i];
            System.out.println("Sum till " + i + " index is " + prefixSum[i]);
        }
    }
}