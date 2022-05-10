import java.util.ArrayList;

public class MaxSumSubarrayOfSizeK {

    // TC = O(N*K), AS = O(1)
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        if (N < K)
            return -1;

        int maxSum = 0;
        for(int i = 0; i <= N - K; i++) {
            int sum = 0;
            for(int j = i; j < (i + K); j++) {
                sum += Arr.get(j);
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // TC = O(N), AS = O(1)
    static int maximumSumSubarray2(int K, ArrayList<Integer> Arr,int N) {
        if (N < K)
            return -1;

        int maxSum = 0, sum = 0;
        int start = 0, end = K;

        // Compute sum of first window of size K
        for(int i = 0; i < K; i++) {
            sum += Arr.get(i);
        }
        maxSum = sum;

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        while(end < N) {
            sum = sum + Arr.get(end) - Arr.get(start);
            end++;
            start++;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
