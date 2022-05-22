import java.util.HashMap;

public class LongestSubArrayWithSumK {
    // TC = O(N^2), AS = O(1)
    public static int lenOfLongSubarr (int[] A, int N, int K) {
        int maxLen = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0, j = i;
            while(j < N) {
                sum += A[j];
                if(sum == K) {
                    maxLen = Math.max((j - i + 1), maxLen);
                }
                j++;
            }
        }
        return maxLen;
    }
    // TC = O(N), AS = O(1)
    public static int lenOfLongSubarr1(int A[], int N, int K) {
        int i = 0, j = 0, sum = 0;
        int maxLen = 0;

        while (j < N) {
            sum += A[j];
            if (sum < K) {
                j++;
            } else if (sum == K) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            } else if (sum > K) {
                while (sum > K) {
                    sum -= A[i];
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }

    // TC = O(N), AS = O(n)
    // Also, works for -ve numbers
    public static int lenOfLongSubarr2 (int A[], int N, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < N; i++) {

            // prefix sum
            sum += A[i];

            // when subarray starts from index '0'
            if (sum == K)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-K' is present in 'map'
            // or not
            if (map.containsKey(sum - K)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - K)))
                    maxLen = i - map.get(sum - K);
            }
        }
        return maxLen;
    }
}
