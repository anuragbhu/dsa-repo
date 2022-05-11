public class LongestSubArrayWithSumK {
    // TC = O(N^2), AS = O(1)
    public static int lenOfLongSubarr (int[] A, int N, int K) {
        int maxLen = 0, length = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0, j = i;
            while(j < N) {
                sum += A[j];
                if(sum == K) {
                    length = j - i + 1;
                    maxLen = Math.max(length, maxLen);
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
}
