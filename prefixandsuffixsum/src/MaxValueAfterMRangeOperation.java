public class MaxValueAfterMRangeOperation {
    // TC = O(n+m), AS = O(1)
    long findMax(int n, int m, long[] a, long[] b, long[] k) {
        long[] arr = new long[n + 1];

        for (int i = 0; i < m; i++) {
            int lowerbound = (int) a[i];
            int upperbound = (int) b[i];

            arr[lowerbound] += k[i];
            arr[upperbound + 1] -= k[i];
        }
        long sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
