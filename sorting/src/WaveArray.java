import java.util.Arrays;

public class WaveArray {
    // TC = O(nlogn)
    // Use this approach if asked for lexicographically smallest.
    public int[] wave(int[] A) {
        // Sort the input array
        Arrays.sort(A);

        int n = A.length;
        // Swap adjacent elements
        for (int i=0; i<n-1; i += 2)
            swap(A, i, i+1);
        return A;
    }

    // TC = O(n)
    // Otherwise, use it.
    public int[] wave1(int[] A) {
        int i = 1, n = A.length;
        while(i < n) {
            if(A[i] > A[i-1])
                swap(A, i, i-1);

            if(A[i] > A[i+1] && i+1 < n)
                swap(A, i, i+1);

            i += 2;
        }
        return A;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
