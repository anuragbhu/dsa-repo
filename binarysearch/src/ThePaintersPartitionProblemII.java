public class ThePaintersPartitionProblemII {
    // algorithm with O(nlog n) runtime complexity.
    static long minTime(int[] arr,int n,int k){
        int N = n;
        int M = k;

        // if(N < M) return -1;
        long start = -1, end = 0, res = -1;

        for(int i = 0; i < arr.length; i++) {
            end += arr[i];
            if(arr[i] > start) start = arr[i];
        }

        while(start <= end) {
            long mid = start + (end - start)/2;
            if(isValid(arr, N, M, mid)) {
                res = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static boolean isValid(int[]A, int N, int M, long mid) {
        int students = 1;
        long sum = 0;
        for(int i = 0; i < N; i++) {
            sum += A[i];

            if(sum > mid) {
                students++;
                sum = A[i];
            }

            if(students > M)
                return false;
        }
        return true;
    }
}
