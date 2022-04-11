import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
One final piece of wisdom: keep practicing dynamic programming. No matter how frustrating these algorithms may seem,
repeatedly writing dynamic programs will make the sub-problems and recurrences come to you more naturally.
 */

// TC using Plain recursion will be O(2^n)
// TC using memoization will be O(n) * O(1) and SC will be O(n) for storing result in 1-D / DP array/map and O(n) for
// recursion Stack, where O(1) will time taken for calls.
// TC using tabulation will be O(n) and SC will also be O(n) for storing result in 1-D / DP array/map
public class NthTermFibonacci {

    public static int fibI(int n, int[] arr) {
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

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
        List<Integer> count = new ArrayList<>();
        count.add(0, 0);
        int[] arr = new int[n+1]; // For storing the result. // Memo array

        Arrays.fill(arr, -1); // Why -1, because Fibonacci number can't be -ve. i.e. it cannot be the possible ans.

//        System.out.println(fib(n, arr, count)); // Fail for fib(10^6)

        System.out.println(fibI(n, arr));
    }
}
