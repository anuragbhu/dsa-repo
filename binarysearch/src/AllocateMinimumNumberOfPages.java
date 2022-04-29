public class AllocateMinimumNumberOfPages {
    public static boolean isValid(int[]A, int N, int M, int mid) {
        int students = 1, sum = 0;
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

    // algorithm with O(nlog n) runtime complexity.
    public static int findPages(int[]A,int N,int M) {

        if(N < M) return -1;
        int start = -1, end = 0, res = -1;

        for(int i = 0; i < A.length; i++) {
            end += A[i];
            if(A[i] > start) start = A[i];
        }

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isValid(A, N, M, mid)) {
                res = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }
}
