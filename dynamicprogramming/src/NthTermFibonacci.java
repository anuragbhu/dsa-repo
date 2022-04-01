import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NthTermFibonacci {
    public static int fib(int n, int[] arr, List<Integer> count) {

        if(n == 0 || n == 1) { // Seed term of Fibonacci Series
            return n;
        }

        // Uncomment if not considering the DP approach.
        // DP -> O(n), Brute-Force -> O(2^n)
        if(arr[n] != -1) {
            return arr[n];
        }

        int call = count.get(0);
        call++;
        count.add(0, call);
        System.out.print(count.get(0) + " ");

        int store = fib(n-1, arr, count) + fib(n-2, arr, count);
        arr[n] = store;
        return store;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // For counting the number of times function call.
        List<Integer> count = new ArrayList<Integer>();
        count.add(0, 0);
        int[] arr = new int[n+1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        System.out.println(fib(n, arr, count));
    }
}
