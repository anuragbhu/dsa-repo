public class MaxValueAfterMRangeOperation {
    long findMax(int n, int m, long  a[], long b[], long k[])
    {
        int[] arr = new int[n];

        for(int i = 0; i < m; i++)
        {

            int lowerbound = (int) a[i];
            int upperbound = (int) b[i];


            for(int j = lowerbound; j <= upperbound; j++)
                arr[j] += k[i];
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
            res = Math.max(res, arr[i]);

        return res;
    }
}
