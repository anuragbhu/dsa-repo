import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
    // TC = O(N), AS = O(N)
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        if (N < K)
            return new long[1];

        long[] res = new long[N-K+1];
        Queue<Long> queue = new LinkedList<>();

        int start = 0, end = 0;
        int index = 0;

        while(end < N) {
            if(A[end] < 0)
                queue.add(A[end]);

            if((end - start + 1) == K) {
                if(!queue.isEmpty())
                    res[index++] = queue.peek();
                else
                    res[index++] = 0;

                if(!queue.isEmpty() && A[start] == queue.peek())
                    queue.poll();

                start++;
            }
            end++;
        }
        return res;
    }

    // TC = O(N*K), AS = O(1)
    public long[] printFirstNegativeInteger1(long A[], int N, int K) {
        if (N < K)
            return new long[1];

        long[] res = new long[N-K+1];
        int k = 0;

        for(int i = 0; i <= N - K; i++) {
            boolean added = false;
            for(int j = i; j < (i + K); j++) {
                if(A[j] < 0) {
                    res[k] = A[j];
                    added = true;
                    break;
                }
            }
            if(!added)
                res[k] = 0;
            k++;
        }
        return res;
    }
}
