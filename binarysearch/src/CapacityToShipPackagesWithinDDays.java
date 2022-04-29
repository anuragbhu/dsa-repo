public class CapacityToShipPackagesWithinDDays {
    // algorithm with O(nlog n) runtime complexity.
    public int shipWithinDays(int[] weights, int days) {
        int N = weights.length;
        int M = days;

        if(N < M) return -1;
        int start = -1, end = 0, res = -1;

        for(int i = 0; i < weights.length; i++) {
            end += weights[i];
            if(weights[i] > start) start = weights[i];
        }

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isValid(weights, N, M, mid)) {
                res = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }

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
}
