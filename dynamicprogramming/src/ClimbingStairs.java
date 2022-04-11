import java.util.Arrays;

public class ClimbingStairs {
    // Recursive/Iterative: Time Complexity: O(n), Auxiliary Space: O(n) for array & O(n) for stack.
    public int climbStairs(int n) {
        // return fibI(n+1);
        return fibII(n+1);
    }

    public static int fibI(int n) {
        int[] arr = new int[n+1];

        Arrays.fill(arr, -1);

        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    // Add space optimizing
    // Recursive/Iterative: Time Complexity: O(n), with no Auxiliary Space
    public static int fibII(int n) {

        int prev0 = 0;
        int prev1 = 1;

        for(int i = 2; i <= n; i++) {
            int curr = prev0 + prev1;
            prev0 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
